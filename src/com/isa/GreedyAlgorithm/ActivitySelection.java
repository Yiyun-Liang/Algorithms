package com.isa.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isa on 2017-03-09.
 */
public class ActivitySelection {

    /*
        * two intervals [si, fi) and [sj, fj) do not overlap iff
        * si <= fj && sj <= fi

        Problem:
            1) given a list of activities with their start and finish time, schedule the maximum number
               of activities that requires exclusive use of a common resource in the time interval
               - solved below
            2) schedule all the activities using as few lecture halls as possible
               - solution: maintain one F(free) set and one B(Busy) set.
                           whenever a new start time is encountered take one from F and move to B
                           if F is empty, add a mth new lecture hall to F
                           because this means m activities are happening simultaneously, so at least m halls are needed
     */

    // top-down greedy algorithm solution
    // assume n input activities are already ordered by monotonically increasing finish time
    // if not, we sort them first in O(nlgn) time
    // recursive

    // k is the subproblem Sk we are solving, n is number of initial input
    // k's initial value is 0
    // O(n) because each activity is examined only once in the while loop
    // returns the index of the activity in the result set
    public static List<Integer> recursive_activity_selector(
            int[] starts, int[] finishes, int k, int n, List<Integer> candidates)
    {
        int m = k + 1;

        // finds the first activity that has start time >= finish time of the first activity(earliest finish time)
        // m is the next k
        while(m < n && starts[m] < finishes[k]){
            m++;
        }

        if(m < n){
            candidates.add(k);
            return recursive_activity_selector(starts, finishes, m, n, candidates);
        }else{
            return candidates;
        }
    }

    // iterative O(n)
    // same assumption
    public static List<Integer> iterative_activity_selector(
            int[] starts, int[] finishes)
    {
        List<Integer> candidates = new ArrayList<>();
        int n = starts.length;

        if(starts.length == 0 || finishes.length == 0){
            return candidates;  // return empty list
        }

        int k = 0;
        candidates.add(k);

        for(int m = k+1; m < n; m++){
            if(starts[m] >= finishes[k]){
                candidates.add(m);
                k = m;
            }
        }

        return candidates;
    }

    // we can use a Activity class having two fields, start and finish
    // or we can use two arrays starts and finishes where same index means same activity
}
