package com.leetcode.test295.isSubsequence;

//392. Is Subsequence
class Solution {
  public boolean isSubsequence(String s, String t) {
    if(s.isBlank()) return true;
    int i = 0;
    for(char c : t.toCharArray()) {
      if(s.charAt(i) == c) i++;
      if(i == s.length()) return true;
    }
    return false;
  }
}
