package com.isa.Interviews.Trees;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by isa on 2017-04-01.
 */
public class BSTSequence {
    /*
        A binary search tree was created by traversing through an array from
        left to right and inserting each element.

        Given a binary search tree with distinct elements, print all possible arrays
        that could have led to this tree.

            2
           / \
          1  3

        Output: {2, 1, 3}, {2, 3, 1}
     */

    class Node{
        int key;
        Node left;
        Node right;
    }

    public static ArrayList<LinkedList<Integer>> sequences(Node root){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(root == null){
            result.add(new LinkedList<>());
            return result;
        }


        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.key);

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = sequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = sequences(root.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void weaveLists(
            LinkedList<Integer> first, LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {

        /* One list is empty. Add the remainder to [a cloned] prefix and
		 * store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

		/* Recurse with head of first added to the prefix. Removing the
		 * head will damage first, so we’ll need to put it back where we
		 * found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

		/* Do the same thing with second, damaging and then restoring
		 * the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
