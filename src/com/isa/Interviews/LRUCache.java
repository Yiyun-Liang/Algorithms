package com.isa.Interviews;

import java.util.HashMap;

/**
 * Created by isa on 2017-04-24.
 */
public class LRUCache {
    /*
        Hash map:
            - good at retrieving values by key
            - bad at tracking by timestamp
        Linked list:
            - good at tracking by timestamp
            - not fast for retrieving values by key

        USE BOTH (not heap in this case because ?)
            - use doubly linked list for easy removal of a node in the middle of the list
            - hash map contains <key, a pointer/reference to the ll node>
            - a node in the ll contains the value

        1) insertion of <key, value>
            - a new linked list node with key, value; insert into head of the linked list (newest at head)
            - insert into map <key,node>

        2) retrieve value by key
            - get value from node from hashmap by key
            - update most recently used item = remove this node and insert back from the head of the list
            - hash map does not change

        3) find least recently used
            - at the end of the linked list

        4) removal
            - remove the node from doubly linked list
            - remove key from hash map
     */

    public class Cache {
        private int maxCacheSize;
        private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
        private LinkedListNode listHead = null;
        public LinkedListNode listTail = null;

        public Cache(int maxSize) {
            maxCacheSize = maxSize;
        }

        // inner class enough: no other classes need this
        private class LinkedListNode{

        }
    }

}
