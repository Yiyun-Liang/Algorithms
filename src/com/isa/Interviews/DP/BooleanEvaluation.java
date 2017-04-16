package com.isa.Interviews.DP;

import java.util.HashMap;

/**
 * Created by isa on 2017-04-16.
 */
public class BooleanEvaluation {
    /*
        Given a boolean expression consisting of the symbols
        0 (false), 1 (true), & (AND), | (OR), and ^ (XOR),
        and a desired boolean result value result,
        implement a function to count the number of ways of parenthesizing the expression
        such that it evaluates to result.

        EXAMPLE
        countEval("1^0|0|1", false) -> 2
        countEval("0&0&0&1^1|0", true) -> 10
     */

    // bottom-up, only look at the structure for all parens on a expression based on length from 1 to n
    /*public static int countEval(String expression, boolean result){
        int length = expression.length();
        boolean[][] res = new boolean[length][length];

        for(int len = 1; len <= length; len++){
            for(int i = 0; i < length-1-len; i++){
                int j = len+i;

                // split
                for(int k = i; k < j; k++){
                    char op = expression.charAt(k);
                    boolean q = eval(res[i][k], op, res[k + 1][j]);

                    res[i][j] = q;
                }
            }
        }
    }*/

    public static int count = 0;
    public static boolean stringToBool(String c) {
        return c.equals("1") ? true : false;
    }

    public static int countEval(String s, boolean result, HashMap<String, Integer> memo) {
        count++;
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
        if (memo.containsKey(result + s)) return memo.get(result + s);

        int ways = 0;

        for (int i = 1; i < s.length(); i += 2) { // +2 every time so that operator is skipped and next number is read
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') { // required: one true and one false
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') { // required: both true
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') { // required: anything but both false
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        memo.put(result + s, ways);
        return ways;
    }

    public static int countEval(String expression, boolean result){
        return countEval(expression, result, new HashMap<String, Integer>());
    }

    public static void main(String[] args) {
        String expression = "0^0|1&1^1|0|1";
        boolean result = true;

        System.out.println(countEval(expression, result));
        System.out.println(count);
    }
}
