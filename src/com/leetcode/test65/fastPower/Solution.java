package com.leetcode.test65.fastPower;

//#50
class Solution {
  public double myPow (double x, int n) {

    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n == -1) {
      return 1 / x;
    }
    double ans = 0;
    long i = 0;
    int remain = 0;
    if (n < 0) {
      ans = 1/x;
      for (i = -2; i >= n; i *= 2) {
        ans *= ans;
        remain = (int) i;
      }
    } else {
      ans = x;
      for (i = 2; i <= n; i *= 2) {
        ans *= ans;
        remain = (int) i;
      }
    }
    return ans * myPow(x, n - remain);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    double ans = s.myPow(0.00001, 2147483647);
    System.out.println(ans);
  }
}
