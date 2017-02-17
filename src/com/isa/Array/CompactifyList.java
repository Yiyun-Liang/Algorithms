package com.isa.Array;

/**
 * Created by isa on 2017-02-16.
 */
public class CompactifyList {
    /*
        There is an array, maintained with a free list
        want to compact all the used items to the front, and all the free space at the end
     */

    /*
        Solution: (every item occupies same amount of space)
            - two pointers
            - p1 moves in the forward direction until encounters a free item
            - p2 moves from the tail to the head until encounters a used item
            - swap content of p1 and p2
            - stop when p1 meets p2
            - reorganize free list pointers
     */
}
