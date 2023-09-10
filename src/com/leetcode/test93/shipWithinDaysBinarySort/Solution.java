package com.leetcode.test93.shipWithinDaysBinarySort;

//#1011
public class Solution {
  public int shipWithinDays (int[] weights, int days) {
    int maxCap = 0;
    int minCap = 0;
    int midCap = -1;
    for (int w : weights) {
      minCap = Math.max(minCap, w);
      maxCap += w;
    }
    while (minCap <= maxCap) {
      midCap = minCap + maxCap;
      midCap /= 2;
      int currWeightSum = 0;
      int currDays = 1;
      for (int w : weights) {
        if (currWeightSum + w <= midCap) {
          currWeightSum += w;
        } else {
          currWeightSum = 0;
          currWeightSum += w;
          currDays++;
        }
      }
      if (currDays > days) {
        if (minCap == midCap) {
          minCap++;
        } else {
          minCap = midCap;
        }
      } else {
        if (maxCap == midCap) {
          maxCap--;
        } else {
          maxCap = midCap;
        }
      }
    }
    return midCap;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    System.out.println(ans);
  }
}
