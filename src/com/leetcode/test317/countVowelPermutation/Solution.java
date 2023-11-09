package com.leetcode.test317.countVowelPermutation;

class Solution {
  static int MOD = 1_000_000_000 + 7;
  public int countVowelPermutation (int n) {
    long a = 1;
    long e = 1;
    long i = 1;
    long o = 1;
    long u = 1;
    for (int I = 1; I < n; I++) {
      long a_next = (e + i + u) % MOD;
      long e_next = (a + i) % MOD;
      long i_next = (e + o) % MOD;
      long o_next = i;
      long u_next = (o + i) % MOD;
      a = a_next;
      e = e_next;
      i = i_next;
      o = o_next;
      u = u_next;
    }
    long ans = a + e + i + o + u;
    ans %= MOD;
    return (int) ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.countVowelPermutation(2);
  }
}
