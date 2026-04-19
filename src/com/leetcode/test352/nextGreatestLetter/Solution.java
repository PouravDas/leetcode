package com.leetcode.test352.nextGreatestLetter;

public class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    int l = 0;
    int r = letters.length - 1;
    int ans = 0;
    while (l <= r) {
      int m = (r + l) / 2;
      if (letters[m] > target) {
        ans = m;
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return letters[ans];
  }
}