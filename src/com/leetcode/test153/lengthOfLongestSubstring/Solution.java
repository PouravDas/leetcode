package com.leetcode.test153.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
// sliding window / two pointers
public class Solution {
  public int lengthOfLongestSubstring (String s) {
    int ans = 0;
    int start = 0;
    int end = 0;
    Set<Character> set = new HashSet<>();
    while (end < s.length()) {
      char c = s.charAt(end);
      if (!set.contains(c)) {
        set.add(c);
        end++;
        ans = Math.max(ans,set.size());
      } else {
        while (set.contains(c)){
          char old = s.charAt(start);
          set.remove(old);
          start++;
        }
      }
    }
    return ans;
  }
}
