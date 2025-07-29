package com.leetcode.test333.candy;

import java.util.Arrays;

public class Solution {
  public int candy(int[] ratings) {
    int count[] = new int[ratings.length];
    Arrays.fill(count, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) count[i] = count[i - 1] + 1;
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1] && (count[i] <= count[i + 1])) count[i] = count[i + 1] + 1;
    }
    return Arrays.stream(count).sum();
  }
}
