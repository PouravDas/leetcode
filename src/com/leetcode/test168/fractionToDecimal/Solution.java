package com.leetcode.test168.fractionToDecimal;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public String fractionToDecimal (long numerator, long denominator) {
    boolean pos = false;
    String ans = "";
    if (numerator == 0)
      return "0";
    if (numerator < 0 && denominator < 0 || numerator >= 0 && denominator > 0) {
      pos = true;
    }
    if (!pos) {
      numerator = Math.abs(numerator);
      denominator = Math.abs(denominator);
      ans = "-";
    }
    ans += numerator / denominator;
    numerator = numerator % denominator;
    if (numerator == 0) {
      return ans;
    }
    ans += ".";
    Map<Long, Integer> map = new HashMap<>();
    map.put(numerator, ans.length());
    while (numerator != 0) {
      numerator *= 10;
      if (numerator < denominator) {
        ans += "0";
      } else {
        ans += numerator / denominator;
        map.put(numerator / 10, ans.length() - 1);
        numerator = numerator % denominator;
        if (map.containsKey(numerator)) {
          String first = ans.substring(0, map.get(numerator));
          String last = ans.substring(map.get(numerator));
          return first + "(" + last + ")";
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.fractionToDecimal(2, 3);
  }
}
