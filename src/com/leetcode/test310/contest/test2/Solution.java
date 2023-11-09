package com.leetcode.test310.contest.test2;

class Solution {
  public String shortestBeautifulSubstring (String s, int k) {
    int l = 0, r = 0;
    String ans = "";
    int count = 0;
    while (r < s.length() && count < k) {
      if (s.charAt(r++) == '1') {
        count++;
      }
    }
    if (count == k)
      ans = s.substring(l, r);
    while (l < s.length() && count == k) {
      while (l < s.length() && count == k) {
        if (s.charAt(l++) == '1') {
          count--;
        } else {
          if (ans.length() > r - l) {
            ans = s.substring(l, r);
          } else if (ans.length() == r - l) {
            String sub = s.substring(l, r);
            ans = ans.compareTo(sub) < 0 ? ans : sub;
          }
        }
      }
      while (r < s.length() && count < k) {
        if (s.charAt(r++) == '1') {
          count++;
        }
      }
      if (count == k) {
        if (ans.length() > r - l) {
          ans = s.substring(l, r);
        } else if (ans.length() == r - l) {
          String sub = s.substring(l, r);
          ans = ans.compareTo(sub) < 0 ? ans : sub;
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.shortestBeautifulSubstring("100011001", 3);
  }
}
