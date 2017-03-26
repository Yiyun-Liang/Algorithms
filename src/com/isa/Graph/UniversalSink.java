package com.isa.Graph;

/**
 * Created by isa on 2017-03-26.
 */
public class UniversalSink {
    /*
        use adjacency matrix representation of a graph
        directed graph

        determine if G contains a universal sink - a vertex with in degree V-1 and out degree 0
        given a adj matrix
     */

    /*
        Start by examining position (1,1) in the adjacency matrix. When examining
        position (i, j), if a 1 is encountered, examine position (i+ 1, j). If a 0 is encountered,
        examine position (i, j + 1). Once either i or j is equal to |V|, terminate.

        I claim that if the graph contains a universal sink, then it must be at vertex
        i. To see this, suppose that vertex k is a universal sink. Since k is a universal
        sink, row k in the adjacency matrix is all 0’s, and column k is all 1’s except for
        position (k, k) which is a 0. Thus, once row k is hit, the algorithm will continue
        to increment j until j = |V|. To be sure that row k is eventually hit, note that
        once column k is reached, the algorithm will continue to increment i until it
        reaches k. This algorithm runs in O(V) and checking whether or not i in fact
        corresponds to a sink is done in O(V). Therefore the entire process takes O(V)
     */

    public boolean containsUniversalSink(Graph G){
        return false;
    }
}
