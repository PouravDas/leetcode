package com.leetcode.test134.knapsack;

//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
public class Solution {
  static int knapSack (int W, int wt[], int val[], int n) {
    int[] prev = new int[W + 1];
    int[] cur = new int[W + 1];
    for (int i = 0; i < n; i++) {
      int w = wt[i];
      int v = val[i];
      for (int j = 1; j < W + 1; j++) {
        if (j < w) {
          cur[j] = prev[j];
        } else {
          cur[j] = Math.max(prev[j], v + prev[j - w]);
        }
      }
      prev = cur;
      cur = new int[W + 1];
    }
    return prev[W];
  }

  public static void main (String[] args) {
    int ans = knapSack(10, new int[] {1, 3, 4, 6}, new int[] {20, 30, 10, 50}, 4);
    System.out.println(ans);
  }
}
