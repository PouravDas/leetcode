package com.leetcode.test268.isInterleave;

import java.util.HashMap;
import java.util.Map;

//97. Interleaving String
class Solution {
  public boolean isInterleave (String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length())
      return false;
    Map<Integer, Boolean> map = new HashMap<>();
    return isInterleave(s1, 0, s2, 0, s3, 0, map);
  }

  boolean isInterleave (String s1, int i1, String s2, int i2, String s3, int i3,
      Map<Integer, Boolean> dp) {
    if (i3 == s3.length())
      return true;
    int tho = 1000;
    int key = i1 * tho * tho + i2 * tho + i3;
    if (dp.containsKey(key))
      return dp.get(key);
    boolean ans = false;
    if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
      if (isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1, dp))
        ans = true;
    }
    if (!ans && i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
      if (isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1, dp))
        ans = true;
    }
    dp.put(key, ans);
    return ans;
  }
}
