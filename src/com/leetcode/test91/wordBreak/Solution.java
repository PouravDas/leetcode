package com.leetcode.test91.wordBreak;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// # 139
public class Solution {
  public boolean wordBreak (String s, List<String> wordDict) {
    Boolean[] dp = new Boolean[s.length()];
    return findWordAt(0, s, wordDict, dp);
  }

  private boolean findWordAt (int i, String s, List<String> wordDict, Boolean[] dp) {
    if (i == s.length())
      return true;
    else if (Objects.nonNull(dp[i]) && !dp[i]) {
      return false;
    } else {
      for (String word : wordDict) {
        if (s.length() - i < word.length()) {
          continue;
        } else if (s.substring(i, i + word.length()).equals(word)) {
          boolean found = findWordAt(i + word.length(), s, wordDict, dp);
          dp[i] = found;
          if (found) {
            return true;
          }
        }
      }
      if (dp[i] == null) {
        dp[i] = false;
      }
      return dp[i];
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //boolean ans = s.wordBreak("leetcode", Arrays.asList("leet", "code"));
    boolean ans = s.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
    System.out.println(ans);
  }
}
