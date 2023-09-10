package com.leetcode.test228.maxSatisfied;

//1052. Grumpy Bookstore Owner
class Solution {
  public int maxSatisfied (int[] customers, int[] grumpy, int minutes) {
    for (int i = 0; i < grumpy.length; i++) {
      grumpy[i] *= customers[i];
    }
    int sum = 0;
    int start = 0, end = 0;
    while (end < minutes) {
      sum += grumpy[end++];
    }
    int i = 0, j = end - 1, max = sum;

    while (end < grumpy.length) {
      sum += grumpy[end++];
      sum -= grumpy[start++];
      if (sum > max) {
        max = sum;
        i = start;
        j = end - 1;
      }
    }
    int ans = 0;
    for (int k = 0; k < i; k++) {
      if (grumpy[k] == 0)
        ans += customers[k];
    }
    for (int k = i; k <= j; k++) {
      ans += customers[k];
    }
    for (int k = j + 1; k < customers.length; k++) {
      if (grumpy[k] == 0)
        ans += customers[k];
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.maxSatisfied(new int[]{2,6,6,9}, new int[]{0,0,1,1},1);
  }
}
