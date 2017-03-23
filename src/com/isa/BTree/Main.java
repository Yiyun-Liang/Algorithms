package com.isa.BTree;

/**
 * Created by isa on 2017-03-22.
 */
public class Main {
    /*
        B-Tree
          a self-balancing tree data structure that keeps data sorted
          a generalization of a binary search tree in that a node can have more than two children
          commonly used in databases and filesystems

        - Advantages:
            optimized for systems that read and write large blocks of data
            minimize number of DISK-READ and DISK-WRITE
            a B-tree node is usually as large as a whole disk page, and this size limits the # of children a node can have

        - Properties:

            1) Every node x has the following attributes:
               - x.n stores the number of keys currently stored in x
               - x.n keys, x.key1~x.keyn, stored in ascending Order, so that x.key1 <= ... <= x.keyn
               - x.leaf, a boolean value, true if x is a leaf and false if x is an internal node

               - Each internal node x also contains x.n+1 pointers x.c1~x.cn+1 to its children
                 leaf nodes have no children, so their c attributes are undefined
                 (eg. a non leaf node with n-1 keys must have n number of children)

            2) ordered
               if ki is any key in the subtree with root x.ci, then
               k1 <= x.key1 <= k2 <= x.key2 <= ... <= kx.n+1

            3) All the leaf nodes have the same depth, which is the tree's height.

            4) Nodes have a lower and a upper bound on the number of keys they can contain
               we express these bounds in terms of a fixed integer t >= 2 -> minimum degree of the B-tree

               Sometimes expressed as B-tree of order m where m = 2t
               - all internal nodes except root(at least one key) must have
                    at least t-1 keys(t children) and
                    maximum of 2t-1 keys(2t children).

                 - if the tree is non-empty, the root must have at least one key(2 children)
                 - a node is full if it contains exactly 2t-1 keys

            eg. 2-3-4 tree(a.k.a. 2-4 tree, order 4), used to implement dictionaries
                2–3–4 trees are an isometry of red–black trees, meaning that they are equivalent data structures.
                2–3–4 trees, however, can be difficult to implement in most programming languages because
                of the large number of special cases involved in operations on the tree.
                Red–black trees are simpler to implement, so tend to be used instead.

                when t = 2, at least 1 key, at most 2t-1=3 keys
                every internal node has either 2, 3, or 4 children


            Note: larger values of t yields B-trees with smaller height
     */
}
