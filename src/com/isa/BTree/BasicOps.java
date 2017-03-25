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

    /*
        Insertion:
            we insert the new key into an existing leaf node
            if the leaf node is full, we use SPLIT operation on a full node y(2t-1 keys)
            around its median key y.kt into two nodes having only t-1 keys
            then the median key moves up into y's parent, may leaf to several split operations

            same as bst insertion, we insert a key on a single pass from root to a leaf,
            ! as we travel down from the root, we split each full node we come to along the way,
            so that whenever we want to split a full node y, we are assured that its parent is not full.

            takes O(th) = O(tlgn): lg base t time
            performs O(h) disk accesses

            insertNonFull is tail-recursive,
            so the number of pages that need to be in main memory at any time is O(1)
     */
    public void insert(Node root, int key, int t){
        // check if root node is full
        // if yes, then create an empty root node, then split original root node
        // if not, proceed to use the normal insert method
        if(root.n == (2*t-1)){
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.c[0] = root;
            splitChild(s, 0, t);
            insertNonFull(s, key, t);
        }else{
            insertNonFull(root, key, t);
        }
    }

    public void insertNonFull(Node x, int key, int t){
        int i = x.n-1;
        // if x is already a leaf node, find position for key, move keys to the back at the same time
        if(x.leaf){
            while(i >= 0 && x.keys[i] > key){
                x.keys[i+1] = x.keys[i];
                i--;
            }
            x.keys[i+1] = key;
            x.n++;
            // disk-write(x) because x is changed
        }else{
            while(i >=0 && x.keys[i] > key){
                i--;
            }
            i++;
            // disk-read(x.c[i])

            // if the children key is going to along this way is full, split this child
            if(x.c[i].n == 2*t-1){
                splitChild(x, i, t);  // split x's ith child
                if(key > x.keys[i]){  // after splitting, x.keys[i] is the newly promoted median node from x.c[i]
                    i++; // need to check against this newly promoted node
                }
            }
            insertNonFull(x.c[i], key, t);
        }
    }

    /*
        Split:
            takes a non-full internal node x, and a index i such that x.ci is a full child of x
            create a new node first, etc
            takes O(t) time and performs O(1) disk operation

            t is not necessarily a parameter, it is part of the attribute of the tree
     */
    public void splitChild(Node x, int i, int t){
        Node z = new Node();   // allocate-node in main memory, no disk-read, yes disk-write later
        Node y = x.c[i];

        // setup properties for newly created node z
        z.leaf = y.leaf;
        z.n = t-1;
        for(int j = 0; j < t-1; j++){  // total of t-1 nodes
            z.keys[j] = y.keys[j+t];
        }

        // if y is not a leaf node, move half of y's children to z
        if(!y.leaf){
            for(int j = 0; j < t; j++){  // total of t children
                z.c[j] = y.c[j+t];
            }
        }

        // setup properties for node y
        y.n = t-1;
        // second half of x's children are moved one position back to
        // make room for the newly promoted node from y
        for(int j = x.n; i >= i; j--){
            x.c[j+1] = x.c[j];
        }
        x.c[i+1] = z; // c[i] is y and c[i+1] is z now

        //
        for(int j = x.n-1; j >= i; j--){
            x.keys[j+1] = x.keys[j];
        }
        x.keys[i] = y.keys[t];
        x.n++;
        //DISK-WRITE(y, z, x);
    }

    /*
        Deletion:
        
     */

}
