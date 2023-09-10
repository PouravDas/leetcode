package com.leetcode.test262.repeatedSubstringPattern;

import java.util.ArrayList;
import java.util.List;

//459. Repeated Substring Pattern
class Solution {
  public boolean repeatedSubstringPattern (String s) {
    if(s.length() < 2) return false;
    List<Integer> multiples = getMultiplesOf(s.length());
    for (int i = multiples.size() - 1; i >-1 ; i--) {
      int m = multiples.get(i);
      int start = 0;
      boolean isRepeating = true;
      while (start + m + m <= s.length()) {
        String s1 = s.substring(start, start + m);
        String s2 = s.substring(start + m, start + m + m);
        if(!s1.equals(s2)) {
          isRepeating = false;
          break;
        }
        start = start + m;
      }
      if(isRepeating) return true;
    }
    return false;
  }

  private List<Integer> getMultiplesOf (int length) {
    List<Integer> multi = new ArrayList<>();
    for (int i = 1; i * 2 <= length ; i++) {
      if(length % i == 0) multi.add(i);
    }
    return multi;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.repeatedSubstringPattern("abcabc");
  }
}
