package com.isa.DynamicProgramming;

/**
 * Created by isa on 2017-02-26.
 */
public class Main {

    public static void main(String[] args){
        int[] prices = {0,1,5,8,9,10,17,17,20,24,30};
        RodCutting rdc = new RodCutting();

        //rdc.printRodCuttingSolution(prices, 10);
        //rdc.printRodCuttingMaxProfit(prices, 10);

        Fibonacci fib = new Fibonacci();
        int s = fib.fibBottomUp(7);
        System.out.println(s);
    }
}
