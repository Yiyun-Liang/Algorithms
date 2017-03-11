package com.isa.GoogleIO2016.Polynesiaglot;

/**
 * Created by isa on 2017-03-10.
 */
public class Polynesiaglot {
    // https://code.google.com/codejam/contest/8274486/dashboard#s=p2
    /*
        Ursula is a big fan of constructing artificial languages. Today, she is starting
        to work on a language inspired by real Polynesian languages. The only rules she has established are:

        1) All words consist of letters. Letters are either consonants or vowels.
        2) Any consonant in a word must be immediately followed by a vowel.

        For example, in a language in which a is the only vowel and h is the only consonant,
        a, aa, aha, aaha, and haha are valid words, whereas h, ahh, ahah, and ahha are not.
        Note that the rule about consonants disallows ending a word in a consonant as well as
        following a consonant with another consonant.

        If Ursula's new language has C different consonants and V different vowels available to use,
        then how many different valid words of length L are there in her language? Since the output
        can be a really big number, we only ask you to output the remainder of dividing the result
        by the prime 109+7 (1000000007).

        Input

        The first line of the input gives the number of test cases, T. T test cases follow.
        Each consists of one line with three integers C, V, and L.

        Output

        For each test case, output one line containing Case #x: y, where x is the test case number
        (starting from 1) and y is the number of different valid words of length L in the language,
        modulo the prime 109+7 (1000000007).

        Example:
        Input                                       Output
        2                                           Case #1: 5
        1 1 4                                       Case #2: 6
        1 2 2
     */

    public static int vowelFollowedByCons(int numConsonants, int numVowels, int length){
        int numArragements = 0;

        return numArragements;
    }
}
