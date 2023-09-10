package com.leetcode.test205.distributeCookies;

class Solution {
  int ans = Integer.MAX_VALUE;

  public int distributeCookies (int[] cookies, int k) {
    helper(cookies, 0, new int[k]);
    return ans;
  }

  void helper (int[] cookies, int idx, int[] children) {
    if (idx == cookies.length) {
      int max = Integer.MIN_VALUE;
      for (int c : children) {
        max = Math.max(max, c);
      }
      ans = Math.min(max, ans);
    } else {
      int cok = cookies[idx++];
      int[] ans = null;
      for (int i = 0; i < children.length; i++) {
        children[i] += cok;
        helper(cookies, idx, children);
        children[i] -= cok;
      }
    }
  }
}
