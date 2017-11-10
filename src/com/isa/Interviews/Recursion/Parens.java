package com.isa.Interviews.Recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by isa on 2017-04-16.
 */
public class Parens {
    /*
         Implement an algorithm to print all valid
         (e.g., properly opened and closed) combinations of n pairs of parentheses.

         Input: 3
         Output: ((())), (()()), (())(), ()(()), ()()()

         ()
         ()(),(())
         ()()(),(())(),()(()),((())),(()())
     */

    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    public static Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
						/* Add s to set if it is not already in there. Note:
						 * HashSet automatically checks for duplicates before
						 * adding, so an explicit check is not necessary. */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    public static Set<String> interativelyGenerateParens(int remaining){
        Set<String> set = new HashSet<>();
        set.add("");

        while(remaining > 0){
            Set<String> newSet = new HashSet<>();

            for(String str: set){
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '('){
                        String s = insertInside(str, i);
                        newSet.add(s);
                    }
                }
                newSet.add("()" + str);
            }
            set = newSet;
            newSet = null;

            remaining--;
        }

        return set;
    }

    public static void main(String[] args) {
        Set<String> list = generateParens(4);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
