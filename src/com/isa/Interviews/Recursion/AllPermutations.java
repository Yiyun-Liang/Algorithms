package com.isa.Interviews.Recursion;

import java.util.ArrayList;

/**
 * Created by isa on 2017-04-12.
 */
public class AllPermutations {
    /*
        Return all permutations of a string
     */

    public static ArrayList<String> getPerms(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();

		/* Base case. */
        if (len == 0) {
            result.add(""); // Be sure to return empty string!
            return result;
        }


        for (int i = 0; i < len; i++) {
			/* Remove char i and find permutations of remaining characters.*/
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms(before + after);

			/* Prepend char i to each permutation.*/
            for (String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
