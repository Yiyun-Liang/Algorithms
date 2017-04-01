package com.isa.Interviews.Graphs;

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

        a----d----c
        |    |
        |    |
        f----b

        Output: f, e, a, b, d, c
     */

    // different from topological sort(requires graph to be acyclic)
    public static void buildOrder(){

    }
}
