package com.isa.Interviews.Graphs;

import com.isa.Graph.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by isa on 2017-04-01.
 */
public class BuildOrder {
    /*
        You are given a list of projects and a list of dependencies
        (which is a list of pairs of projects, where the second project
        is dependent on the first project). All of a project'sdependencies
        must be built before the project is. Find a build order that
        will allow the projects to be built. If there is no valid build order, return an error.

        Input:
        projects: a, b, c, d, e, f
        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

        a--->d--->c
        ^    ^
        |    |
        f--->b

        Output: f, e, a, b, d, c
     */

    public static Graph buildGraph(String[] names, String[][] dependencies){
        Graph graph = new Graph();

        for(String name: names){
            graph.getOrCreateNode(name);
        }

        for(String[] dependency: dependencies){
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    // different from topological sort(requires graph to be acyclic)
    public static boolean buildOrderDFS(Vertex vertex, Stack<Vertex> stack){
        if (vertex.getState() == Vertex.State.PARTIAL) {
            return false; // Cycle
        }

        if (vertex.getState() == Vertex.State.BLANK) {
            vertex.setState(Vertex.State.PARTIAL);
            ArrayList<Vertex> children = vertex.getChildren();
            for (Vertex child : children) {
                if (!buildOrderDFS(child, stack)) {
                    return false;
                }
            }
            vertex.setState(Vertex.State.COMPLETE);
            stack.push(vertex);
        }
        return true;
    }

    /* A helper function to insert projects with zero dependencies
	 * into the order array, starting at index offset. */
    public static int addNonDependent(Vertex[] order, ArrayList<Vertex> projects, int offset) {
        for (Vertex project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    // do a dfs from every vertex
    public static Stack<Vertex> orderProjects(ArrayList<Vertex> vertices) {
        Stack<Vertex> stack = new Stack<>();
        for (Vertex vertex : vertices) {
            if (vertex.getState() == Vertex.State.BLANK) {
                if (!buildOrderDFS(vertex, stack)) {  // false
                    return null;
                }
            }
        }
        return stack;
    }

    // another approach: remove edges
    public static Vertex[] orderProjects2(ArrayList<Vertex> projects) {
        Vertex[] order = new Vertex[projects.size()];

		/* Add “roots” to the build order first.*/
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Vertex current = order[toBeProcessed];

			/* We have a circular dependency since there are no remaining
			 * projects with zero dependencies. */
            if (current == null) {
                return null;
            }

			/* Remove myself as a dependency. */
            ArrayList<Vertex> children = current.getChildren();
            for (Vertex child : children) {
                child.decrementDependencies();
            }

			/* Add children that have no one depending on them. */
            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }

        return order;
    }

    public static Stack<Vertex> findBuildOrder(String[] vertices, String[][] dependencies) {
        Graph graph = buildGraph(vertices, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static String[] buildOrderWrapper(String[] vertices, String[][] dependencies) {
        Stack<Vertex> buildOrder = findBuildOrder(vertices, dependencies);
        if (buildOrder == null) return null;
        String[] buildOrderString = convertToStringList(buildOrder);
        return buildOrderString;
    }

    public static String[] convertToStringList(Stack<Vertex> projects) {
        String[] buildOrder = new String[projects.size()];
        for (int i = 0; i < buildOrder.length; i++) {
            buildOrder[i] = projects.pop().getName();
        }
        return buildOrder;
    }


    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }
}
