package com.isa.BTree;

/**
 * Created by isa on 2017-03-23.
 */
public class BasicOps {

    // assume order 4, then t = 2
    class Node{
        int[] keys;    // 1 <= num keys every node <= 3
        int n;
        boolean leaf;
        Node[] c;      // 2 <= num children every node has <= 4
    }

    class pair{
        Node y;
        int i;  // ith key

        pair(Node y, int i){
            this.y = y;
            this.i = i;
        }
    }

    /*
        Search:
            compared to a binary tree, we now have n+1 branching decisions
            takes O(tlgn) = O(th)
     */
    public pair search(Node node, int key){
        int i = 0;
        while(i < node.n && node.keys[i] < key){   // takes O(t) since node.n < 2t
            i++;
        }

        if(i < node.n && node.keys[i] == key){
            return new pair(node, i);
        }else if(node.leaf){
            return null;
        }else{
            return search(node.c[i], key);          // takes O(lgn) = O(h)
        }
    }
}
