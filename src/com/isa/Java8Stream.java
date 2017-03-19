package com.isa;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * Created by isa on 2017-03-18.
 */
public class Java8Stream {

    // tutorial:
    // http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

    /*
        Lists and Sets support new methods stream() and parallelStream()
        to either create a sequential or a parallel stream.

        Parallel streams are capable of operating on multiple threads.
     */

    public static void main(String[] args){

        // Sequential streams
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        // 1. filter, map, sorted, forEach
        myList
                .stream()
                .filter(s -> s.startsWith("c"))  // intermediate operation
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);  // terminal operation  C1, C2

        // 2. findFirst, ifPresent
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1

        Stream.of("a1", "a2", "a3")  // create a stream from a bunch of object reference
                .findFirst()
                .ifPresent(System.out::println);  // a1

        // 3. streams for primitive types
        IntStream.range(1, 4)
                .forEach(System.out::println);  // 1, 2, 3

        int[] intArr = {1, 4};

        Arrays.stream(intArr)
                .forEach(System.out::println);

        /*
            All those primitive streams work just like regular object streams
            with the following differences: Primitive streams use specialized
            lambda expressions, e.g. IntFunction instead of Function or
            IntPredicate instead of Predicate. And primitive streams support
            the additional terminal aggregate operations sum() and average()
         */
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0

        // 4. map object stream to primitive stream, or vice versa
        List<String> myList2 =
                Arrays.asList("a1", "a2", "a3");

        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3

        myList2.stream()
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3

        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);  // a1, a2, a3

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);  // a1, a2, a3

        // 5. intermediate operations
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });  // nothing printed out because terminal operation not present

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));  // ..., filter: c, forEach: c

        /*
            The order things are printed out is surprising
            it is like pipelining, a2 is executed and d2 is moved forward
         */

        // number of elements executed is reduced
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });  // map: d2, anyMatch: D2, map: a2, anyMatch: A2

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // map:     d2
        // filter:  D2
        // map:     a2
        // filter:  A2
        // forEach: A2
        // map:     b1
        // filter:  B1
        // map:     b3
        // filter:  B3
        // map:     c
        // filter:  C

        /*
            Sorting is a special kind of intermediate operation. It's a so called
            stateful operation since in order to sort a collection of elements you
            have to maintain state during ordering.
         */
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);  // printf in java, similar to string format
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // optimize with reordering
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // filter:  d2
        // filter:  a2
        // filter:  b1
        // filter:  b3
        // filter:  c
        // map:     a2
        // forEach: A2

        // 6. reuse streams
        // Java 8 streams cannot be reused. As soon as you call any terminal operation the stream is closed.
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        //stream.noneMatch(s -> true);   // exception

        // to overcome this limitation
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

        // 7. collect, flatMap, reducd
        // COLLECT:
        // Collect is an extremely useful terminal operation to transform the elements
        // of the stream into a different kind of result, e.g. a List, Set or Map
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());  // Collectors.toSet()

        System.out.println(filtered);    // [Peter, Pamela]

        List<Integer> ints = Arrays.asList(19, 20, 19, 17);

        Set<Integer> set =
                ints
                        .stream()
                        .filter(i -> i.equals(19))
                        .collect(Collectors.toSet());

        System.out.println("set: " + set);    // [19]  no duplicates in set

        // so gao ji
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // age 18: [Max]
        // age 23: [Peter, Pamela]
        // age 12: [David]

        // statistics
        double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println(averageAge);     // 19.0

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        // join
        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                // joining(delimiter, optional prefix, optional suffix)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
        // In Germany Max and Peter and Pamela are of legal age.

        // to map
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        // since keys must be unique(eg.23), we can pass a optional merge function to handle conflict
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
        // {18=Max, 23=Peter;Pamela, 12=David}

        // build our own collector functions
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(  // use this to create a custom collector
                        // since strings are immutable in java, need this stringjoiner to perform joining
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
