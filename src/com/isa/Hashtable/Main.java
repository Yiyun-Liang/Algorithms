package com.isa.Hashtable;

/**
 * Created by isa on 2017-02-18.
 */
public class Main {

    /*
        Direct-Address Tables: for small range of keys

        Hash Tables:
            Hash Functions:
                1) division
                2) multiplication
                3) universal hashing: randomly choose a hash algorithm for a key
            Definition:
                Simple Uniform Hashing: each key is equally likely to be hashed to any of the m slots
                                        in the hashtable, independently of where any other key has hashed to.

        Collisions:

        Performance: 1 and 2 both have average time of O(1) for basic dictionary operations

            1) chaining: better when keys must be deleted
                - doubly linked list if want to support quick deletion
                - simplest resolution

            2) open addressing: avoids pointers to occupy extra space, at most one element/slot

                 to compute probe sequences:
                     - one approach is to apply uniform hashing(too ideal): can produce any probe sequence (1/m!)
                        - this is hard to implement

                 these all guarantees that <h(k,0),h(k,1)...h(k,m-1)> is a permutation of <0,1,...,m-1>
                 none of them satisfies uniform hashing, can generate at most m^2 sequences(instead of m!)
                     - linear probing: (h(k)+i)mod m starting from the initial slot
                        - m distinct sequences
                        - easy to implement
                        - primary clustering: long sequence of occupied slots, average time increases
                     - quadratic probing: (h(k)+c1i+c2i^2)mod m starting from the initial slot
                        - m distinct sequences
                        - better than linear probing, needs good c1, c2 values
                        - secondary clustering
                        - two keys hashed to same value = same sequence
                     - double hashing: (h1(k)+ih2(k))mod m
                        - has the greatest number of probe sequences(m^2), seems to give the best result
                        - must make sure all slots can be visited
                        - closest approach to uniform hashing

                 Performance:
                    hash table   |  number of probes in a successful search
                    -------------------------------------------------------
                     half full   |            < 1.387
                     90 % full   |            < 2.559
     */
}
