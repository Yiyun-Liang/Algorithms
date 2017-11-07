package com.isa.Queue;

import java.util.PriorityQueue;

/**
 * Created by isa on 2017-11-06.
 */
public class PriorityQ {
    /*PriorityQueue<ListNode> queue= new PriorityQueue<>(5, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });*/

    public static void main(String[] args) {
        // min priority queue
        // if type string, order A-Z
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->(a-b));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->(b-a));
        minHeap.add(1);
        minHeap.add(66);
        minHeap.add(4);
        minHeap.add(5);

        maxHeap.add(1);
        maxHeap.add(66);
        maxHeap.add(4);
        maxHeap.add(5);

        int size = maxHeap.size();
        for (int i = 0; i < size; i++) {   // cannot use queue.size() here because removing things on the fly
            System.out.println(maxHeap.poll());
        }
    }
}
