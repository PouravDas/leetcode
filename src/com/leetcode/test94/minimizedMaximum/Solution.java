package com.leetcode.test94.minimizedMaximum;

//# 2064
class Solution {
  public int minimizedMaximum (int n, int[] quantities) {
    int min = 1;
    int max = -1;
    int mid = -1;
    for (int q : quantities) {
      max = Math.max(max, q);
    }
    while (min <= max) {
      mid = min + max;
      mid /= 2;

      int count = 0;
      for (int q : quantities) {
        count += q / mid;
        if (q % mid > 0) {
          count++;
        }
      }
      if (count > n) {
        if (min == mid)
          min++;
        else
          min = mid;
      } else {
        if (max == mid)
          max--;
        else
          max = mid;
      }
    }
    return mid;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minimizedMaximum(6, new int[] {11, 6});
  }
}
