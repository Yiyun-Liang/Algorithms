package com.isa.Graph;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by isa on 2017-03-13.
 */
public class Graph {
    /*
        Definitions of Graphs G = (V, E):

            1) directed graphs
                - have edges with directions
                - the edges indicate a one-way relationship
            2) undirected graphs
                - have edges that do not have directions
                - the edges indicate a two-way relationship
                - each edge can be traversed in both directions

            1) sparse graphs:
                - size(E) is much less than size(V)^2
                - prefer to be represented as a collection of adjacency-list (compact way)
            2) dense graphs:
                - size(E) is close to size(V)^2
                - prefer to be represented as a collection of adjacency-matrix
                    - able to tell quickly if there is an edge connecting two given vertices


         Representations of Graphs: P560 of Introduction to Algorithms
            1) adjacency list
                - contains an array (adj) of size(V) lists, one for each vertex V
                - foreach u in V, adj[u] contains all the vertices v such that there is an edge (u,v) in E
                  (contain all vertices v adjacent to u in G, or contain pointer to these vertices)
                - adj is often treated as an attribute of G, so G.adj[u]

                * directed graph:
                    sums of lengths of all the adjacency list is size(E)
                    (u,v) = having v appeared in adj[u]
                * undirected graph: sums of lengths of all the adjacency list is 2*size(E)
                    (u,v) = having v appeared in adj[u] and vice versa

                - for both types of graphs, memory required of adj list is O(V+E)

                * weighted graph with weight function w: E -> Real #
                    simply store w(u,v) with v in adj[u]

                - disadvantage: no quick way to determine whether a given edge (u,v) is present in G
                                than to search for v in adj[u]
            2) adjacency matrix
                - assume that vertices are represented as numbers from 1 to size(V)
                - then a size(V) * size(V) matrix is constructed such that A = aij such that
                    aij = 1 if(i,j) is in E
                    aij = 0 otherwise

                * directed graph:

                * undirected graph: sums of lengths of all the adjacency list is 2*size(E)
                    symmetry along the main diagonal of the adjacency matrix
                    the adj matrix A is its own transpose A = AT
                    sometimes only store entries on and above the diagonal to cut memory needed to half

                * weighted graph:
                    store weight w(u,v) of edge(u,v) as the entry in row u and column v
                    if edge does not existss, store null, 0, or infinity

                - disadvantages: more space/memory needed (use it for smaller graphs)
                - advantages: one bit per entry for undirected graphs, simpler



     */

    /*
        A graph, implemented using an array of sets.
        Parallel edges and self-loops allowed

        this class represents an undirected graph of vertices
        named 0 through V – 1

        This implementation uses an adjacency-lists representation
        All operations take constant time (in the worst case) except iteration

        Parallel edges and self-loops are permitted
        By convention, a self-loop v-v appears in the
        adjacency list of v twice and contributes two to the degree
        of v
     */
    private final int V;  // number of vertices
    private int E;        // number of edges
    private Bag<Integer>[] adj;  // array of bags as lists

    // initialize a graph with V vertices and 0 edges
    public Graph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Initializes a graph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    public Graph(Scanner in) {
        try {
            this.V = in.nextInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");

            adj = (Bag<Integer>[]) new Bag[V];

            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }

            int E = in.nextInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for (int i = 0; i < E; i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph G = new Graph(in);
        System.out.println(G);
    }
}
