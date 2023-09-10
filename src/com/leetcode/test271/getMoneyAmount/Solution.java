package com.leetcode.test271.getMoneyAmount;

import java.time.temporal.ChronoUnit;

//375. Guess Number Higher or Lower II
class Solution {
  public int getMoneyAmount (int n) {
    if(n < 2) return 0;
    int totalSum = n * (n + 1) / 2;
    int curr = n - 1;
    int gap = 1;
    int amount = 0;
    while ( curr * (curr + 1) / 2 >= totalSum / 2 ) {
      amount += curr;
      curr = curr - gap - 1;
      gap = 2 * gap + 1;
    }
    return amount;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int a = s.getMoneyAmount(10);
    System.out.println(a);
  }
}
