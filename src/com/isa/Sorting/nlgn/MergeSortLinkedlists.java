package com.isa.Sorting.nlgn;

import java.util.LinkedList;

/**
 * Created by isa on 2017-02-12.
 */
public class MergeSortLinkedlists {

    private class Node{
        int data;
        Node next;
    }

    /**
     *
     * @param lists a list of heads to linkedlist
     * @return
     */
    public Node mergeKLists(Node[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }

    public Node mergeKLists(Node[] lists, int lower, int upper){
        if(lower < upper){
            int mid = lower + (upper - lower)/2;
            Node left = mergeKLists(lists, lower, mid);
            Node right = mergeKLists(lists, mid+1, upper);
            return merge(left, right);
        }
        return null;
    }

    Node merge(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.data < list2.data) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }

}
