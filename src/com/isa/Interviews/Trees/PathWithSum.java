package com.isa.Interviews.Trees;

import java.util.HashMap;

/**
 * Created by isa on 2017-04-01.
 */
public class PathWithSum {
    /*
        You are given a binary tree in which each node contains an integer value
        (which might be positive or negative). Design an algorithm to count the
        number of paths that sum to a given value.

        The path does not need to start or end at the root or a leaf,
        but it must go downwards (traveling only from parent nodes to child nodes).
     */

    class Node{
        int key;
        Node left;
        Node right;
    }

    // Solution 1: count number of paths with sum starting from every single node
    // running time: I think it is O(n)
    public static int pathWithSum(Node root, int sum){

        if(root == null) return 0;

        int pathsFromRoot = countPathsWithSumFromNode(root, sum, 0);

        int pathsFromLeftSub = countPathsWithSumFromNode(root.left, sum, pathsFromRoot);
        int pathsFromRightSub = countPathsWithSumFromNode(root.right, sum, pathsFromRoot);

        return pathsFromRoot + pathsFromLeftSub + pathsFromRightSub;
    }

    public static int countPathsWithSumFromNode(Node node, int targetSum, int currentSum){
        if(node == null)  return 0;

        int numPaths = 0;
        currentSum += node.key;

        if(currentSum == targetSum){
            numPaths++;
        }

        numPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        numPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);

        return numPaths;
    }

    // Solution 2
    // ending at current node
    public static int countPathsWithSum(Node root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    public static int countPathsWithSum(Node node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // Base case

        runningSum += node.key;

		/* Count paths with sum ending at the current node. */
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

		/* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
        if (runningSum == targetSum) {
            totalPaths++;
        }

		/* Add runningSum to pathCounts. */
        incrementHashTable(pathCount, runningSum, 1);

		/* Count paths with sum on the left and right. */
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

        incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
        return totalPaths;
    }

    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) { // Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
