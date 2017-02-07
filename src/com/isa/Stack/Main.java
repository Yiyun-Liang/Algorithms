package com.isa.Stack;

/**
 * Created by isa on 2017-02-06.
 */
public class Main {
    /*
        Performance:

        1) Linkedlist structure
            - Every operation takes constant time in the worst case O(1)
            - 40 bytes per stack node
                = 16 object overhead + 8 bytes inner class overhead + 8 bytes(String) + 8 bytes(Node)
        2) Fixed Capacity Array
            - Defect: size is declared beforehand, capacity is defined
        3) Resizing Array(repeated doubling)
            - amortized cost of inserting first N items = 3N (approximately) = N + (2+4+8+...+N)
            - push/pop worst case cost is O(n) but amortized cost is O(1)
            - uses between 8N to 32N bytes to represent a stack with N items
              (only include memory for stack, clients owns strings)
                - around 8N when full
                - around 32N when 1/4 full

        * Depending on the client needs, can use interchangeably
            linkedlist: constant time in the worst case, but use extra time and space to deal with links
            resizing array: amortized constant time, but less wasted space (sudden large workload, but cares total)

    */

    /*
        Stack Considerations:

        1) Underflow: throw exception if pop from an empty stack
        2) Overflow: use resizing array for array implementation

        3) Null Items: we allow null items to be inserted
        4) Loitering(Java): holding a reference to an object when it is no longer needed
            eg. public String pop(){
                    return arr[--index];
                }

            should be refactored to:

            public String pop(){
                String item = s[--index];
                s[index] = null;
                return item;
            }

            so that garbage collector can reclaim memory(no outstanding references)
     */
}
