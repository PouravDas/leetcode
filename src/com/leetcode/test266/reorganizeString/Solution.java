package com.leetcode.test266.reorganizeString;

class Solution {
  public String reorganizeString (String s) {
    char[] arr = s.toCharArray();
    int[] dp = new int[26];
    int max = 0;
    int maxIdx = 0;
    for (char a : arr) {
      dp[a - 'a']++;
      if (dp[a - 'a'] > (s.length() + 1) / 2)
        return "";
      if (dp[a - 'a'] > max) {
        max = dp[a - 'a'];
        maxIdx = a - 'a';
      }
    }
    int idx = 0;
    for (int i = 0; i < dp[maxIdx]; i++) {
      if(idx >= arr.length) idx = 1;
      arr[idx] = (char) ('a' + maxIdx);
      idx += 2;
    }
    dp[maxIdx] = 0;

    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < dp[i]; j++) {
        if(idx >= arr.length) idx = 1;
        arr[idx] = (char) ('a' + i);
        idx += 2;
      }
    }
    return new String(arr);
  }
}
