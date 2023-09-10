package com.leetcode.test58.findTheOriginalArrayOfPrefixXor;

// question #2433
class Solution {
  public int[] findArray (int[] pref) {
    int[] ans = new int[pref.length];
    int tem = 0;

    int i = 0;
    for (int p : pref){
      ans[i] = p ^ tem;
      tem = p;
      i++;
    }

    return ans;
  }
}
