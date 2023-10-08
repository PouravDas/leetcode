package com.leetcode.test296.longestStrChain;

class Solution {
  public int longestStrChain (String[] words) {
    int ans = 0;
    int[] dp = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      ans = Math.max(ans, findChain(i, dp, words));
    }
    return ans;
  }

  int findChain (int idx, int[] dp, String[] words) {
    if (dp[idx] != 0) {
      return dp[idx];
    }
    int ans = 0;
    String word = words[idx];
    for (int i = 0; i < words.length; i++) {
      if (i == idx)
        continue;
      String next = words[i];
      if (word.length() + 1 != next.length())
        continue;
      int w1 = 0, w2 = 0;
      int unMatch = 0;
      while (w1 < word.length() && w2 < next.length() & unMatch <= 1) {
        if (word.charAt(w1) == next.charAt(w2)) {
          w1++;
          w2++;
        } else {
          unMatch++;
          w2++;
        }
      }
      if(w1 == word.length() && unMatch == 0) {
        unMatch++;
      }
      if (unMatch == 1) {
        ans = Math.max(ans, findChain(i, dp, words));
      }
    }
    return dp[idx] = 1 + ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"});
  }
}
