package com.isa.BackTracking;

/**
 * Created by isa on 2017-05-08.
 */
public class Main {

    // TUTORIAL: http://www.dreamincode.net/forums/topic/258287-a-look-at-backtracking/
    /*
        The idea behind backtracking is to attempt a possible solution,
        then as the name implies, backtrack and try another if that path doesn't pan out.
        Backtracking is applicable to problems like the Knight's Tour, N-Queens, and maze solving problems.
     */

    /*
        1 -Pick a starting point
        2 -While the problem isn't solved
        3  -For each path from the starting point
        4     -Set that as the starting point and recurse
        5     -If it returns true, then return true
        6  -Undo the current move (since none of the options panned out)
        7  -Return false
     */

    /*
        Notice how the algorithm returns whether or not the attempt panned out.
        If it didn't, then move onto the next one. If none of the possible attempts
        from the given point worked out, then undo the current move and return false.
        It is important to undo the current move so as to return the state of the program
        before attempting the given path.
     */

    public static void main(String[] args) {

    }
}
