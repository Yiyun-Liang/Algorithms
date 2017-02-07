package com.isa;

/**
 * Created by isa on 2017-02-05.
 */
public class EggDrop {
    /*
        Suppose that you have an n-story building (with floors 1 through n) and plenty of eggs. An egg breaks if it is dropped from floor T or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of T given the following limitations on the number of eggs and tosses:

         Version 0: 1 egg, ≤T tosses.
         Version 1: ∼1lgn eggs and ∼1lgn tosses.
         Version 2: ∼lgT eggs and ∼2lgT tosses.
         Version 3: 2 eggs and ∼2n‾‾√ tosses.
         Version 4: 2 eggs and ≤cT‾‾√ tosses for some fixed constant c.
     */

    /*
        Version 0: sequential search.
        Version 1: binary search.
        Version 2: find an interval containing T of size ≤2T, then do binary search.
        Version 3: find an interval of size n‾‾√, then do sequential search. Note: can be improved to ∼2n‾‾‾√ tosses.
        Version 4: 1+2+3+…+t∼12t2. Aim for c=22‾‾√.
     */
}
