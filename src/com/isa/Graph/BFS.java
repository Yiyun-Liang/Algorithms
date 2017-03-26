package com.isa.Graph;

import java.util.LinkedList;
import java.util.Queue;
import com.isa.Graph.GraphHelper.*;

/**
 * Created by isa on 2017-03-26.
 */
public class BFS {
    /*
        Breadth-first search

            takes a graph represented by adjacency list
            applies to both directed and undirected graphs

        advantages:
            1) computes shortest path from source vertex s to any reachable vertex v, stored in v.d
            2) constructed a breadth-first tree, all vertices are nodes, edges are defined by v.p
     */

    private static final int WHITE = 1;
    private static final int BLACK = 2;
    private static final int GRAY = 3;


    // run time is linear to the adjacency list passed in which is of size O(V+E)
    public void BreadthFirstSearch(GraphHelper G, Vertex s){
        // initialize all vertices to be white, takes O(V)
        for(Vertex v: G.vertices){
            v.color = WHITE;
            v.d = Integer.MAX_VALUE;
            v.p = null;
        }

        s.color = GRAY;
        s.d = 0;
        s.p = null;

        // takes O(V+E)
        Queue queue = new LinkedList();
        queue.add(s);
        // printNode(s);
        while(!queue.isEmpty()) {
            Vertex u = (Vertex)queue.remove();

            for(Vertex v: G.adj(u.k)){  // order of visit may vary depending on which neighbor is visited first
                if(v.color == WHITE){  // ensure each v is enqueued only once
                    v.color = GRAY;
                    v.d = u.d + 1;
                    v.p = u;
                    queue.add(v);
                }
            }
            u.color = BLACK;
        }
    }

    // prints out a shortest path from s to v, assuming bfs has already computed a breadth-first tree
    public void printPath(GraphHelper G, Vertex s, Vertex v){
        if(s.k == v.k){
            System.out.println(s.k);
        }else if(v.p == null){
            System.out.println("No path from s to v exists");
        }else{
            printPath(G, s, v.p);
            System.out.println(v.k);
        }
    }
}
