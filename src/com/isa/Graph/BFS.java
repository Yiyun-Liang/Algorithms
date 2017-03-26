package com.isa.Graph;

import java.util.LinkedList;
import java.util.Queue;
import com.isa.Graph.GraphHelper.*;

import static com.isa.Graph.GraphHelper.BLACK;
import static com.isa.Graph.GraphHelper.GRAY;
import static com.isa.Graph.GraphHelper.WHITE;

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

            // below for loop will run V times rather than V's #E times
            // if G is represented with adj matrix,
            // leading to O(V^2) total run time
            for(Vertex v: G.adj(u.k)){  // order of visit may vary depending on which neighbor is visited first
                if(v.color == WHITE){  // ensure each v is enqueued only once
                    v.color = GRAY;
                    v.d = u.d + 1;
                    v.p = u;
                    queue.add(v);
                }
            }
            u.color = BLACK; // can be removed
        }
    }

    // prints out a shortest path from s to v, assuming bfs has already computed a breadth-first tree
    // run time is linear to the number of vertices in the path printed
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

    /*
        diameter is the longest of all shortest simple path distance in the tree

        solution 1:
            run bfs on all vertices -> O(V*(V+E))
            floyd algorithm -> O(V^3)

        solution 2:
            Run BFS twice. For the first time, arbitrarily choose a vertex as the source.
            The second time, let the vertex with largest d[] be the source.
     */
    public int diameter(GraphHelper G){
        return 0;
    }
}
