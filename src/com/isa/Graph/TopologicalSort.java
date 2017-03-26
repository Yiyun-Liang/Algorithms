package com.isa.Graph;

/**
 * Created by isa on 2017-03-26.
 */
public class TopologicalSort {
    /*
        Use DFS to perform a topological sort on a directed acyclic graph("dag")

        Definition of topological sort
            a linear ordering of all its vertices such that if G contains an edge (u,v)
                    then u appears before v in the ordering
                    (if a graph contains a cycle, no linear ordering is possible)

        Definitions of acyclic graph
            An acyclic graph is a graph having no graph cycles.
            Acyclic graphs are bipartite.
            A connected acyclic graph is known as a tree, and
            a possibly disconnected acyclic graph is known as a forest (i.e., a collection of trees).
     */

    // O(V+E)
    public static void sort(GraphHelper G){
        // 1) DFS to compute finishing time v.f for each vertex v, O(V+E)
        // 2) as each vertex is finished, insert it onto the front of a linkedlist, O(1)
        // 3) return the linkedlist of vertices
    }

    /*
        correctness:
            for each edge (u,v) where an edge go from u to v
            we can guarantee that v.f < u.f
                1) v is white: v finish first, then u
                2) v is gray: back edge, self loop, not possible in a dag,
                3) v is black: v.f is already set, u.f set later
     */

    // calculate number of simple path from u to v in a dag
    // use u.paths to store result for (u,v)
    // runs in linear time
    public static int numSimplePath(GraphHelper G, GraphHelper.Vertex u, GraphHelper.Vertex v){
        if(u == v){
            return 1;
        }else if(u.paths != 0){
            return u.paths;
        }else{
            for(GraphHelper.Vertex w: G.adj(u.k)){
                u.paths = u.paths + numSimplePath(G, w, v);
            }
            return u.paths;
        }
    }
}
