package com.leetcode.test167.largestNumber;

import java.util.stream.IntStream;

//179. Largest Number
class Solution {
  public String largestNumber (int[] nums) {
    final StringBuilder sb = new StringBuilder(nums.length);
    IntStream.of(nums).boxed().sorted((a, b) -> {
      String aSt = "" + a;
      String bSt = "" + b;
      int i = 0;
      int j = 0;
      if (aSt.length() > bSt.length()) {
        while (i < aSt.length() * 2) {
          char aChar = aSt.charAt(i % aSt.length());
          char bChar = bSt.charAt(j % bSt.length());
          if (aChar == bChar) {
            i++;
            j++;
          } else {
            return bChar - aChar;
          }
        }
        return 0;
      } else {
        while (j < bSt.length() * 2) {
          char aChar = aSt.charAt(i % aSt.length());
          char bChar = bSt.charAt(j % bSt.length());
          if (aChar == bChar) {
            i++;
            j++;
          } else {
            return bChar - aChar;
          }
        }
        return 0;
      }
    }).forEach(e -> sb.append(e));
    String ans = sb.toString();
    int i = 0;
    while (i < ans.length() && sb.charAt(i) == '0')
      i++;
    ans = ans.substring(i);
    if (ans.isBlank()) {
      return "0";
    } else {
      return ans;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.largestNumber(new int[] {432, 43243});
  }
}
