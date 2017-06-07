package com.isa.Utils;

/**
 * Created by isa on 2017-05-28.
 */
public class GCDLCM {
    // https://stackoverflow.com/questions/4201860/how-to-find-gcd-lcm-on-a-set-of-numbers
    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long gcd(long[] input) {
        long result = input[0];
        for(int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    // reduction by gcd
    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for(int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }
}
