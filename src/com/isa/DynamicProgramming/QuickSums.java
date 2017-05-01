package com.isa.DynamicProgramming;

import java.util.*;
// https://community.topcoder.com/tc?module=ProblemDetail&rd=5072&pm=2829
// https://github.com/gabesoft/topc/blob/master/src.archive.1/dynamic/QuickSums.java
public class QuickSums {
  int[][] data;

  public int minSums(String numbers, int sum) {
    char[] chars = numbers.toCharArray();             // convert string to char array
    int n = chars.length;
    int[] nums = new int[n];

    data = new int[sum+1][n+1];
    for (int i = 0; i < data.length; i++) {
      Arrays.fill(data[i], -1);                       // fill in array
    }

    for (int i = 0; i < chars.length; i++) {
      nums[i] = Character.getNumericValue(chars[i]);
    }

    return solve(nums, sum);
  }

  int solve(int[] nums, int sum) {
    int n = nums.length;

    if (n == 0) { return sum == 0 ? 0 : 1; }
    if (n == 1) { return nums[0] == sum ? 0 : -1; }

    int nsum = arrsum(nums);
    if (sum == 0 && sum == nsum) { return 0; }
    if (sum < nsum) { return -1; }
    if (data[sum][n] > -1) { return data[sum][n]; }

    int[] n1 = new int[n-1];
    int[] n2 = new int[n-1];

    for (int i = 0; i < n1.length; i++) {
      n1[i] = nums[i+1];
      n2[i] = nums[i+1];
    }

    n2[0] = nums[0] * 10 + n2[0];

    int a = solve(n1, sum - nums[0]);
    int b = solve(n2, sum);

    if (a == -1 || b == -1) {
      data[sum][n] = a == -1 ? b : a + 1;
    } else {
      data[sum][n] = Math.min(a + 1, b);
    }

    return data[sum][n];
  }

  int arrsum(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += nums[i];
    }
    return res;
  }

  void debug(Object...os) {
    System.out.println(Arrays.deepToString(os));
  }
}
