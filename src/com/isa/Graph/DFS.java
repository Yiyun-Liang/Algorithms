package com.isa.Graph;

import com.isa.Graph.GraphHelper.*;

import java.util.Stack;

import static com.isa.Graph.GraphHelper.WHITE;
import static com.isa.Graph.GraphHelper.GRAY;
import static com.isa.Graph.GraphHelper.BLACK;

/**
 * Created by isa on 2017-03-26.
 */
public class DFS {
    /*
        Depth-first search

            running time, same as BFS, is O(V+E)

            can be used for directed and undirected graphs

            return a depth-first forest comprising several depth-first trees
            A tree is a connected graph with no cycles.  A forest is a bunch of trees(may not be connected).

        Properties:
        1) valuable info about the structure of the graph, recursion trees
        2) discovery time and finishing time have parenthesis structure

        p609 for different types of edges classified during a DFS
     */
    public int time;  // global time

    public void depthFirstSearch(GraphHelper G){
        // initialization
        for(Vertex v: G.vertices){
            v.color = WHITE;
            v.p = null;
        }

        time = 0;

        for(Vertex v: G.vertices){
            if(v.color == WHITE){
                depthFirstSearch(G, v);
            }
        }
    }

    public void depthFirstSearch(GraphHelper G, Vertex v){
        time++;  // white vertex v has just been discovered
        v.s = time;
        v.color = GRAY;  // can be removed

        for(Vertex u: G.adj(v.k)){  // go deeper
            if(u.color == WHITE){
                u.p = v;
                depthFirstSearch(G, u);
            }
        }

        v.color = BLACK;     // this vertex finished
        time++;
        v.f = time;
    }

    // or
    public void dfs(GraphHelper G, Vertex v) {

        v.color = GRAY;  // visited

        for(Vertex u: G.adj(v.k)){
            if(u.color == WHITE) {
                u.color = GRAY;
                // printNode(child);
                dfs(G, u);
            }
        }
    }

    public void nonrecursiveDFS(Graph G, Vertex s) {

        // depth-first search using an explicit stack
        Stack<Vertex> stack = new Stack<>();
        s.color = GRAY;
        stack.push(s);

        while (!stack.isEmpty()) {
            Vertex v = stack.peek();
            // true replace with G.adj(v.k).hasNext()

            if (true) {

                Vertex w = null; // replace with = G.adj(v.k).next();
                if (w.color == WHITE) {
                    // discovered vertex w for the first time
                    w.color = GRAY;
                    // edgeTo[w] = v;
                    stack.push(w);
                }
            } else {
                stack.pop();
            }
        }
    }
}
