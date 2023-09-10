package com.leetcode.test158.divideTwoIntegeres;
// 29. Divide Two Integers
public class Solution {
  public int divide (long dividend, long divisor) {
    int ans = 0;
    boolean same = false;
    if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
      same = true;
    }
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    if (dividend == divisor) return same ? 1 : -1;
    else if(divisor == 1) return (int) (same ? dividend : -1 * dividend);
    while (dividend > divisor) {
      int shifts = 0;
      while (divisor << shifts < dividend) {
        shifts++;
      }
      dividend -= divisor << --shifts;
      ans += 1 << shifts;
      shifts = 0;
    }
    return same ? ans : ans * -1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.divide(10, -3);
    System.out.println(ans);
  }
}
