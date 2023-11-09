package com.leetcode.test322.countHomogenous;

class Solution {
  public int countHomogenous (String s) {
    long ans = 0;
    int l = 0, r = 0;
    while (r < s.length()) {
      while(r < s.length() && s.charAt(l) == s.charAt(r)) r++;
      long len = r - l;
      ans += len * (len + 1) / 2;
      ans %= 1_000_000_000 + 7;
      l = r;
    }
    return (int) ans;
  }
}
