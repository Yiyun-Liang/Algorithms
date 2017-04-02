package com.isa.Interviews.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isa on 2017-04-02.
 */
public class Graph {

    private ArrayList<Vertex> nodes = new ArrayList<Vertex>();
    private HashMap<String, Vertex> map = new HashMap<String, Vertex>();

    public Vertex getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Vertex node = new Vertex(name);
            nodes.add(node);
            map.put(name, node);
        }

        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Vertex start = getOrCreateNode(startName);
        Vertex end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Vertex> getNodes() {
        return nodes;
    }
}
