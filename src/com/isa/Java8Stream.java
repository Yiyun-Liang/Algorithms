package com.isa;

import java.util.Arrays;
import java.util.List;
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

    }
}
