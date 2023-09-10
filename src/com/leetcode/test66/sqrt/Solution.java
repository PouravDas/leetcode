package com.leetcode.test66.sqrt;

public class Solution {

  public int mySqrt (int x) {
    return (int) mySqrt(1L * x);
  }
  public long mySqrt (long x) {

    if (x == 0 || x == 1) {
      return x;
    }
    long start = 1;
    long end = x / 2;
    while (true) {
      long mid = (end + start) / 2;
      if (mid * mid <= x && (mid + 1) * (mid + 1) > x)
        return mid;

      if (mid * mid < x) {
        start = mid + 1;

      } else {
        end = mid - 1;
      }
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.mySqrt(2147395599);
    System.out.println(ans);
  }
}
