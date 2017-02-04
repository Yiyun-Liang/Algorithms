package com.isa.UnionFind;

/**
 * Created by isa on 2017-02-04.
 */
public interface UF {

    // add connection between p and q
    public void union(int p, int q);

    // are p and q in the same component
    public boolean connected(int p, int q);

    // component identifier for p
    public int find(int p);

    // number of components
    public int count();
}
