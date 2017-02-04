package com.isa.UnionFind;

/**
 * Created by isa on 2017-02-04.
 */
public class Main {

    /**
     *          M union-find operations on a set of N objects
     *
     *  |-------------------------------------------------------------------|
     *  | algorithm           | initialize | union | find | worst-case time |
     *  |-------------------------------------------------|-----------------|
     *  | quick find          |      N     |   N   |   1  |       M N       |
     *  |-------------------------------------------------|-----------------|
     *  | quick union         |      N     |   N   |   N  |       M N       |
     *  |-------------------------------------------------|-----------------|
     *  | weighted qu         |      N     |  lgN  | lgN  |    N + M lgN    |  depth of any node x is at most lg(2)N - proof 1
     *  |-------------------------------------------------|-----------------|
     *  |qu + path compression|      N     |  lgN  | lgN  |    N + M lgN    |
     *  |-------------------------------------------------|-----------------|
     *  |weighted qu + pc     |      N     |              |    N + M lg*N   |  iterated log function, think as < 5
     *  |-------------------------------------------------------------------|
     *
     *  It is proven there is no linear time solution to the union find problem.
     */

    /**
     *  proof 1:
     *      Increases by 1 when tree T1 containing x is merged into another tree T2.
     *          The size of the tree containing x at least doubles since | T 2 | ≥ | T 1 |.
     *          Size of tree containing x can double at most lg N
     *
     *  Scalability:
     *      lgN is more scalablly acceptable
     *          because if in the future, computers are 10X faster,
     *          and we have a 10X larger dataset,
     *          our algorithm runs faster
     *
     *
     *  Ex. 10^9 unions and finds on 10^9 objects (1 billion)
     *      - WQUPC reduces time from 30 years to 6 seconds
     *      - supercomputers won't help much, good algorithms enables solutions
     */

    /**
     * Quick find defect - union too expensive (N array access)
     *                   - trees are flat, but too expensive to keep them flat
     *                   - takes N^2 to process N union commands on N objects
     *
     */

    /**
     * Quick union defect - trees can get too tall,
     *                    - find operation will be too expensive (could be N access)
     *
     * Quick union improvements
     *                    - weighing: take steps to avoid tall trees
     *                        - keep track of size of each tree
     *                        - balance by linking root of smaller tree to root of larger tree
     *                        - (avoid putting tall trees low)
     */

    public static void main(String[] args) {
        //int n = StdIn.readInt();
    }

}
