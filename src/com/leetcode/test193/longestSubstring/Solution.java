package com.leetcode.test193.longestSubstring;

//395. Longest Substring with At Least K Repeating Characters
class Solution {
  public int longestSubstring (String s, int k) {
    if (k < 2)
      return s.length();
    if (s.length() < k)
      return 0;

    int[] charCount = new int[26];
    for (char c : s.toCharArray()) {
      charCount[c - 'a'] += 1;
    }
    int i = 0;
    while (i < s.length() && charCount[s.charAt(i) - 'a'] >= k) {
      i++;
    }

    if (i == s.length())
      return s.length();
    else {
      int ans = longestSubstring(s.substring(0, i), k);
      while (i < s.length() && charCount[s.charAt(i) - 'a'] < k)
        i++;
      ans = Math.max(ans, longestSubstring(s.substring(i), k));
      return ans;
    }
  }
}
