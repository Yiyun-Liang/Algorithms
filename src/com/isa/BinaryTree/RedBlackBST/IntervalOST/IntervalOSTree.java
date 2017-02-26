package com.isa.BinaryTree.RedBlackBST.IntervalOST;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by isa on 2017-02-24.
 */
public class IntervalOSTree {

    Node root;

    class Interval{
        int low;  // low endpoint
        int high;
    }

    class Node{
        Interval interval;  // stored in bst based on low endpoints
        Node left;
        Node right;
        Node parent;

        int max;  // max high endpoint rooted at this node, used for overlaps searches
                  // this.max = max(this.interval.high, this.left.max, this.right.max)
    }

    // finds a node in tree whose interval overlaps interval i, o/w return null
    // to overlap i, n.interval.low <= i.interval.high && i.interval.low <= n.interval.high
    public Node searchOverlaps(Interval i){
        Node r = root;

        // as soon as one interval that overlaps with i is found, terminates
        while(r != null && !overlaps(r.interval, i)){
            if(r.left != null && r.left.max >= i.low){
                r = r.left;
            }else{
                r = r.right;
            }
        }

        return r;
    }

    public Node searchOverlapsWithLowestEndpoint(Interval i){
        Node r = root;
        int lowest = Integer.MAX_VALUE;

        while(r != null){
            if(overlaps(r.interval, i)){
                lowest = Math.min(r.interval.low, lowest);
            }

            if(r.left != null && r.left.max >= i.low){
                r = r.left;
            }else{
                r = r.right;
            }
        }

        return r;
    }

    public Node searchOverlapsExactly(Interval i){
        Node n = null;
        // n = search(i.low);  // this is normal binary search tree search
        if(n.interval.high == i.high){
            return n;
        }else{
            return null;
        }
    }

    // list all intervals in the tree that overlaps i in O(min(k, klgn)) time where
    // k is the number of intervals in the output list
    public void printAllOverlaps(Node root, Interval i){
        if(overlaps(root.interval, i)){
            System.out.println("[" + root.interval.low + ", " + root.interval.high + "]");
        }

        if(root.left != null && root.left.max >= i.low){
            printAllOverlaps(root.left, i);
        }

        // since root has the smallest low endpoint among its right subtree !!!
        if(root.right != null && root.right.max >= i.low && root.interval.low <= i.high){
            printAllOverlaps(root.right, i);
        }
    }

    /*
        ArrayList<Node> output = new ArrayList<>();

        // one way to convert arraylist<type> to type[]
        Node[] outputArr = new Node[output.size()];
        return output.toArray(outputArr);
     */

    private boolean overlapsExactly(Interval a, Interval b){
        return a.low == b.low && a.high == b.high;
    }

    private boolean overlaps(Interval a, Interval b){
        boolean first = a.low <= b.high;
        boolean second = b.low <= a.high;

        return first && second;
    }
}
