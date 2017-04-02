package com.isa.Interviews.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isa on 2017-04-02.
 */
public class Vertex {
    public enum State {COMPLETE, PARTIAL, BLANK};

    private ArrayList<Vertex> children = new ArrayList<Vertex>();
    private HashMap<String, Vertex> map = new HashMap<String, Vertex>();
    private String name;
    private State state = State.BLANK;
    private int dependencies = 0;

    public Vertex(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Vertex node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State st) {
        state = st;
    }

    public ArrayList<Vertex> getChildren() {
        return children;
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public int getNumberDependencies() {
        return dependencies;
    }
}
