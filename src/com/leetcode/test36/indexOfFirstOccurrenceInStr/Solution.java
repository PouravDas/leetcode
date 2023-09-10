package com.leetcode.test36.indexOfFirstOccurrenceInStr;

public class Solution {

  public int strStr (String haystack, String needle) {

    int i = 0;
    while (i < haystack.length()) {

      int j = 0;
      while (j < needle.length() && i + j < haystack.length()
          && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      }
      if (j == needle.length())
        return i;

      if (j > 0) {
        i += j;
      } else {
        i++;
      }
    }
    return -1;
  }

  public static void main (String[] args) {

    Solution s = new Solution();

    int ans = s.strStr("leetcode", "leeto");

    System.out.println(ans);
  }
}
