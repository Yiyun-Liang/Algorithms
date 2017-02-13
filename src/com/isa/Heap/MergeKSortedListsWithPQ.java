package com.isa.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by isa on 2017-02-12.
 */
public class MergeKSortedListsWithPQ {

    public class ListNode{
        int val;
        ListNode next;
    }

    /*
        Time complexity: O(nlgk) where k is number of sorted lists, n is total number of nodes
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null||lists.length == 0)
            return null;

        // a max heap
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode();
        head.val = 0;
        ListNode p = head;  // pointer to head node


        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);   // inserts the specified element into this priority queue
        }

        while(!queue.isEmpty()){
            // O(lgk)
            ListNode n = queue.poll();   // retrieves and removes the head of this queue, return null if empty
            p.next = n;
            p = p.next;

            // takes O(lgk) times for inserting 1 node into a priority queue of k nodes
            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;
    }
}
