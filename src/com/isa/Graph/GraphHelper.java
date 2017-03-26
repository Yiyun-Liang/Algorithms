package com.isa.Graph;

import sun.security.provider.certpath.Vertex;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by isa on 2017-03-13.
 */
public class GraphHelper {
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

    public static final int WHITE = 1;
    public static final int BLACK = 2;
    public static final int GRAY = 3;

    class Vertex{
        int k;
        int color;
        Vertex p;  // predecessor of this vertex, null if no predecessor

        // used only in bfs
        int d;  // distance from source vertex to this vertex

        // used only in dfs
        // values between 1 and 2|V|
        int s;  // first time the vertex is grayed, discovery time
        int f;  // first time the vertex is blackened, finishing time
    }

    private final int V;  // number of vertices
    private int E;        // number of edges
    private Bag<Vertex>[] adj;  // array of bags as lists
    public Vertex[] vertices;

    // initialize a graph with V vertices and 0 edges
    public GraphHelper(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Vertex>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Vertex>();
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
    public GraphHelper(Scanner in) {
        try {
            this.V = in.nextInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");

            adj = (Bag<Vertex>[]) new Bag[V];

            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Vertex>();
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
        Vertex one = new Vertex();
        one.k = w;
        Vertex two = new Vertex();
        one.k = v;

        adj[v].add(one);
        adj[w].add(two);
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Vertex> adj(int v) {
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
            for (Vertex w : adj[v]) {
                s.append(w.k + " ");
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
        GraphHelper G = new GraphHelper(in);
        System.out.println(G);
    }
}
