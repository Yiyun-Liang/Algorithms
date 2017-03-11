package com.isa.GoogleIO2016;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by isa on 2017-03-09.
 */
public class StoreSales {
    /*
        Problem:

        Cody, the owner of the legendary Cody's Jams store, is planning a huge jam sale.
        To make things simple, he has decided to sell every item in his store at a 25% discount —
        that is, each item's sale price is exactly 75% of its regular price. Since all of his
        regular prices happened to be integers divisible by four, his sale prices are
        conveniently also all integers.

        To prepare for the sale, he placed an order to print new labels for all of his items at
        their sale prices. He also placed an order to print new labels for all of his items at
        their regular prices, to use once the sale is over.

        Cody just came back from picking up his order. Unfortunately, the printer gave him both
        orders in one combined stack, sorted by price. Both the sale price and the regular price
        label for each item are present somewhere in the stack. However, both types of labels
        look the same, and since he does not remember the price of every item, he is not sure
        which labels are the sale price labels. Can you figure that out?

        For instance, if the regular prices were 20, 80, and 100, the sale prices would be 15,
        60, and 75, and the printer's stack would consist of the labels 15, 20, 60, 75, 80, and 100.

        Input:
        The first line of the input gives the number of test cases, T. T test cases follow.
        Each test case consists of two lines. The first line contains a single integer N, the number
        of items in Cody's store. The second line contains 2N integers P1, P2, ..., P2N in non-decreasing
        order by the price printed on each label given by the printer.

        Output:
        For each test case, output one line containing Case #x: y, where x is the test case number (starting
        from 1) and y is a list of N integers: the labels containing sale prices, in non-decreasing order.

        Example:
        Input                                       Output
        2                                           Case #1: 15 60 75
        3                                           Case #2: 9 9 12 15
        15 20 60 75 80 100
        4
        9 9 12 12 12 15 16 20
     */

    public static int[] separatePrices(int numItems, int[] prices){

        Map<Integer, Integer> map = new HashMap<>();
        int[] salePrices = new int[numItems];  // need to be in increasing order
        int count = 0;

        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            int sale = price/4*3;
            if(price%4 == 0 && map.containsKey(sale)){
                int val = map.get(sale);

                salePrices[count] = sale;

                if(val == 1) {
                    map.remove(sale);
                } else {
                    map.put(sale, map.get(sale)-1);
                }

                count++;
                continue;
            }

            if(map.containsKey(price)){                // can probably be combined into one statement?
                map.put(price, map.get(price)+1); // auto-boxing
            }else{
                map.put(price, 1);
            }
        }

        Arrays.sort(salePrices);

        return salePrices;
    }

    public static void main(String[] args){

        int[] prices = {15, 20, 60, 75, 80, 100};
        int[] prices2 = {9, 9, 12, 12, 12, 15, 16, 20};

        // read from file
        List<String> lines = null;
        String testcaseInputPath = System.getProperty("user.dir")
                + "/src/com/isa/GoogleIO2016/A-large-practice-StoreSales.in";
        String testcaseOutputPath = System.getProperty("user.dir")
                + "/src/com/isa/GoogleIO2016/A-large-practice-StoreSales.out";

        try{
            lines = Files.readAllLines(Paths.get(testcaseInputPath));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        int numCases = Integer.parseInt(lines.get(0));
        StringBuilder output = new StringBuilder();

        for(int i = 1; i < lines.size(); i+=2){
            // numItems
            int numItems = Integer.parseInt(lines.get(i));
            // int array of mixed prices
            String pricesString = lines.get(i+1);
            String[] mixedPrices = pricesString.split("\\s+"); // split using whitespace as delimiter
            int[] intPrices = new int[mixedPrices.length];
            for(int j = 0; j < mixedPrices.length; j++) {
                intPrices[j] = Integer.parseInt(mixedPrices[j]);
            }

            int[] salesPrices = separatePrices(numItems, intPrices);
            StringBuilder sb = new StringBuilder();
            for(int p: salesPrices){
                sb.append(p);
                sb.append(" ");
            }
            output.append(String.format("Case #%d: %s\n", i/2+1, sb.toString()));
        }


        // write to a file
        try{
            Files.write(Paths.get(testcaseOutputPath),
                    output.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e){
            e.printStackTrace();
        }

        /*
            An alternative way of reading from a file with BufferReader
            by reading the filename from command line

            $ MY_PROGRAM < small_input.txt > small_output.txt

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
              int n = in.nextInt();
              int m = in.nextInt();
              System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
            }
         */
    }
}
