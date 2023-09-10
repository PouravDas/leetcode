package com.leetcode.test152.palindromePartitioningEasy;

import java.util.List;

//131. Palindrome Partitioning
public class Solution {
  public List<List<String>> partition (String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int gap = 0; gap < s.length(); gap++) {
      for (int row = 0, col = gap; col < s.length(); row++, col++) {

      }
    }
    return null;
  }
}
