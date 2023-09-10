package com.leetcode.test59.countDigitOne;

public class Solution {
  public int countDigitOne (int num) {
    int ans = 0;
    long n = num;

    for (long i = 10; i <= n * 10; i = i * 10) {
      long left = n / i;
      long mid = (n / (i / 10)) % 10;
      long right = n % (i / 10);

      ans += left * i / 10;
      if (mid == 0) {

      } else if (mid == 1) {
        ans += right + 1;
      } else {
        ans += i / 10;
      }
    }

    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.countDigitOne(824883294);
    System.out.println(ans);
  }
}
