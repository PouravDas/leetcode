package com.leetcode.test231.contest355;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> splitWordsBySeparator (List<String> words, char separator) {
    List<String> ans = new ArrayList<>();
    for (String w : words) {
      int start = 0;
      int end = 0;
      while (end < w.length()) {
        if (w.charAt(end) == separator) {
          if (start != end)
            ans.add(w.substring(start, end));
          start = end + 1;
        }
        end++;
      }
      if (start < w.length() && start != end) {
        ans.add(w.substring(start, w.length()));
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.splitWordsBySeparator(List.of("one.two.three", "four.five", "six"), '.');
  }
}
