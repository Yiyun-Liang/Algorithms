package com.isa.Interviews.Recursion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isa on 2017-04-16.
 */
public class AllPermutationsTwo {
    /*
        Return all permutations of a string (the string may contain duplicated characters
     */

    public static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c,  count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c,  count);
            }
        }
    }

    public static ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }
}
