package com.isa.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by isa on 2017-06-07.
 */
public class BidirectionalSearch {
    public static class Node {
        private final int data;
        private final Set<Node> adjacent = new HashSet<Node>();

        public Set<Node> getAdjacent() {
            return adjacent;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        // returns if the node was added, false if already there
        public boolean addAdjacent(Node node) {
            return adjacent.add(node);
        }

        // returns true if any were added
        public boolean addAdjacents(Set<Node> nodes) {
            return adjacent.addAll(nodes);
        }
    }

    public static boolean pathExistsBidirectional(Node a, Node b) {
        // BFS on both nodes at the same time
        Queue<Node> queueA = new LinkedList<>();
        Queue<Node> queueB = new LinkedList<>();
        Set<Node> visitedA = new HashSet<>();
        Set<Node> visitedB = new HashSet<>();

        visitedA.add(a);
        visitedB.add(b);
        queueA.add(a);
        queueB.add(b);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (pathExistsBidirectionalHelper(queueA, visitedA, visitedB)) {
                return true;
            }
            if (pathExistsBidirectionalHelper(queueB, visitedB, visitedA)) {
                return true;
            }
        }

        return false;
    }

    private static boolean pathExistsBidirectionalHelper(Queue<Node> queue, Set<Node> visitedFromThisSide, Set<Node> visitedFromThatSide) {
        if (!queue.isEmpty()) {
            Node next = queue.remove();
            for (Node adjacent : next.getAdjacent()) {
                if (visitedFromThatSide.contains(adjacent)) {
                    return true;
                } else if (visitedFromThisSide.add(adjacent)) {
                    queue.add(adjacent);
                }
            }
        }
        return false;
    }
}
