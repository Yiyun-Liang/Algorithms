package com.isa.Interviews.Trees;

import edu.princeton.cs.algs4.RandomSeq;

import java.util.Random;

/**
 * Created by isa on 2017-04-01.
 */
public class RandomNode {
    /*
        You are implementing a binary tree class from scratch which,
        in addition to insert, find, and delete, has a method getRandomNode()
        which returns a random node from the tree. All nodes should be equally
        likely to be chosen. Design and implement an algorithm for getRandomNode,
        and explain how you would implement the rest of the methods.
     */

    // this is a node class

    int key;
    RandomNode left;
    RandomNode right;

    int size;

    public void insert(int k){
        if(k <= key){
            if(left == null){
                left = new RandomNode();
                left.key = k;
            }else{
                left.insert(k);
            }
        }else{
            if(right == null){
                right = new RandomNode();
                right.key = k;
            }else{
                right.insert(k);
            }
        }

        size++;
    }

    public RandomNode find(int k) {
        if (k == key) {
            return this;
        } else if (k <= key) {
            return left != null ? left.find(k) : null;
        } else if (k > key) {
            return right != null ? right.find(k) : null;
        }
        return null;
    }

    public RandomNode getRandomNode(){
        int leftSize = this.left.size;

        Random random = new Random();
        int rand = random.nextInt(size);

        if(rand < leftSize){
            return left.getRandomNode();
        }else if(rand == leftSize){
            return this;
        }else{
            return right.getRandomNode();
        }
    }

    public RandomNode getIthNode(int i){
        int leftSize = this.left.size;

        if(i == leftSize+1){
            return this;
        }else if(i <= leftSize){
            return left.getIthNode(i);
        }else{
            return right.getIthNode(i-(leftSize+1));
        }
    }
}
