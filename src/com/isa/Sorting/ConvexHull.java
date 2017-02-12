package com.isa.Sorting;

/**
 * Created by isa on 2017-02-11.
 */
public class ConvexHull {
    /*
        Given a set of points,
        return the set of vertices that encloses all points.
        output in counterclockwise order.

        Applications:
            - shortest path from s to t to avoid an polygon obstacle
            - given n points in a plane, find the a pair of points with the largest Euclidean distance
                = extreme points on the convex hull
     */

    /*
        Graham scan: use a stack, push and pop points
            1) choose point p with smallest y coordinates
            2) sort points by polar angle with p
            3) consider points in order; discard unless it creates a ccw turn
     */

    /*
        - create a stack of points
        - sort according to y coors
        - sort according to polar coors
        - push first two elements in the array
        - ccw(poped, peek, next)
     */
}
