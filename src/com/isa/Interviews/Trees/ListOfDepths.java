package com.isa.Interviews.Trees;

import java.util.*;

/**
 * Created by isa on 2017-04-01.
 */
public class ListOfDepths {
    /*
        Given a binary tree, design an algorithm which creates a linked list of all
        the nodes at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
     */

    // binary tree node
    static class Node{
        int key;
        Node[] children;

        Node(int key){
            this.key = key;
        }
    }

    // BFS
    public static ArrayList<LinkedList<Node>> listOfDepths(Node root){
        // rule 1: make it as easy for the client as possible
        if(root == null){  // don't forget to check this
            return null;
        }

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

        LinkedList<Node> current = new LinkedList<>();

        current.add(root);
        //result.add(copyList(queue));  // objects(eg. lists) are passed around by reference, be CAREFUL

        while(!current.isEmpty()){
            result.add(current);  // add previous level

            LinkedList<Node> parents = current;  // go to next level
            current = new LinkedList<>();

            for(Node parent: parents){
                for(Node child: parent.children){
                    current.add(child);
                }
            }
        }

        return result;
    }

    // DFS
    // initial depth is 0 for root node
    public static void listOfDepth(Node root, ArrayList<LinkedList<Node>> result, int depth){

        if(root == null){
            return;
        }

        LinkedList<Node> list = null;

        if(list.size() == depth+1){
            list = new LinkedList<>();
            result.add(list);
        }else{
            list = result.get(depth);
        }

        list.add(root);
        result.add(depth, list);  // java.util.ArrayList.add(int index, E elemen), add to index

        for(Node child: root.children){
            depth++;
            listOfDepth(child, result, depth);
        }
    }


    // have not checked whether right or not
    public static void printResult(ArrayList<LinkedList<Node>> result){
        int depth = 0;
        for(LinkedList<Node> entry : result) {
            Iterator<Node> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((Node)i.next()).key);
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        // create queue in java with linkedlist
        Queue<String> myQueue = new LinkedList<>();
        Queue<Integer> myNumbers = new LinkedList<>();

        myQueue.add("Hello");
        myQueue.add("World");

        myNumbers.add(1);
        myNumbers.add(2);
        int n = myNumbers.remove();
        System.out.println(n);  // should be 1
    }

}
