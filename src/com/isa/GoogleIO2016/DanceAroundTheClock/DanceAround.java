package com.isa.GoogleIO2016.DanceAroundTheClock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by isa on 2017-03-10.
 */
public class DanceAround {
    /*
        The owner of a prestigious ballroom has painted a beautiful circular clock
        on the dance floor, and a group of D dancers numbered 1 through D are about
        to literally "dance around the clock". They are standing in a circle, with
        dancer 1 at the 12:00 position of the circle and the other dancers going
        clockwise around the circle in increasing numerical order. The number of dancers is even.

        The dance will go on for N turns. On the i-th turn (counting starting from 1), the following will happen:

        If i is odd, then the dancer currently at the 12:00 position will swap positions with the
        next dancer in clockwise order. Then, going past those two, the next pair of dancers in
        clockwise order will swap positions, and so on, all the way around the ring clockwise,
        until all dancers have participated in exactly one swap.

        If i is even, then the dancer currently at the 12:00 position will swap positions with the
        next dancer in counterclockwise order. Then, going past those two, the next pair of dancers
        in counterclockwise order will swap positions, and so on, all the way around the ring
        counterclockwise, until all dancers have participated in a swap.


        Input

        The first line of the input gives the number of test cases, T. T test cases follow. Each consists
        of one line with three integers D, K, and N: the total number of dancers, the number of one of the
        dancers, and the number of turns the dance will go on for.

        Output

        For each test case, output one line containing Case #x: y z, where:

        x is the test case number (starting from 1).
        y is the number of the dancer who will be standing to dancer number K's left (that is,
        one step away in clockwise order) when the dance is over.
        z is the number of the dancer who will be standing to dancer number K's right (that is,
        one step away in counterclockwise order) when the dance is over.

        Example:
        Input                                       Output
        3                                           Case #1: 6 4
        8 3 1                                       Case #2: 1 7
        8 4 2                                       Case #3: 2 4
        4 1 8
     */

    static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public static Node dance(int numDancers, int dancer, int numTurns){
        // setup doubly circular linked list as n dancers around the clock
        // head is at 12 o'clock position
        // next is in clockwise direction
        Node head = new Node(1);
        Node pointer = head;
        for(int i = 2; i <= numDancers; i++){
            Node n = new Node(i);
            n.prev = pointer;
            pointer.next = n;
            pointer = pointer.next;
            if(i == numDancers) {
                n.next = head;
                head.prev = n;
            }
        }

        for(int i = 1; i <= numTurns; i++){
            pointer = head;

            if(i%2 != 0){
                // odd
                for(int j = 0; j < numDancers/2; j++){
                    swap(pointer, pointer.next);
                    pointer = pointer.next.next;
                }
            }else{
                //even
                for(int j = 0; j < numDancers/2; j++) {
                    swap(pointer, pointer.prev);
                    pointer = pointer.prev.prev;
                }
            }
        }

        // get left and right dancers for dancer
        pointer = head;
        while(pointer.value != dancer){
            pointer = pointer.next;
        }

        // return pointer to that specified dancer
        return pointer;
    }

    // swap values in two nodes in a doubly linkedlist
    public static void swap(Node a, Node b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args){

        // read from file
        /*List<String> lines = null;
        String testcaseInputPath = System.getProperty("user.dir")
                + "/src/com/isa/GoogleIO2016/DanceAroundTheClock/A-small-practice.in";
        String testcaseOutputPath = System.getProperty("user.dir")
                + "/src/com/isa/GoogleIO2016/DanceAroundTheClock/A-small-practice.out";

        try{
            lines = Files.readAllLines(Paths.get(testcaseInputPath));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        int numCases = Integer.parseInt(lines.get(0));
        StringBuilder output = new StringBuilder();

        for(int i = 1; i <= numCases; i++){
            // all parameters
            String s = lines.get(i);
            String[] params = s.split("\\s+"); // split using whitespace as delimiter
            int[] DKN = new int[params.length];
            for(int j = 0; j < params.length; j++) {
                DKN[j] = Integer.parseInt(params[j]);
            }

            Node thisDancer = dance(DKN[0], DKN[1], DKN[2]);
            StringBuilder sb = new StringBuilder();

            sb.append(thisDancer.next.value);
            sb.append(" ");
            sb.append(thisDancer.prev.value);

            output.append(String.format("Case #%d: %s\n", i, sb.toString()));
        }

        System.out.println(output.toString());

        // write to a file
        try{
            Files.write(Paths.get(testcaseOutputPath),
                    output.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e){
            e.printStackTrace();
        }*/

        Node d = dance(8, 3, 1);
        Node p = dance(4, 1, 8);
        Node q = dance(8, 4, 2);
        System.out.println(p.next.value);
        System.out.println(p.prev.value);
    }
}
