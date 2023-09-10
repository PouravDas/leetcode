package com.leetcode.test137.lcs.longestPalindromicSubsequence;

import java.util.ArrayList;
import java.util.List;

//wrong
public class SolutionMy {
  public int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == rev.charAt(i)) list.add(s.charAt(i));
    }
    return list.size();
  }
}
