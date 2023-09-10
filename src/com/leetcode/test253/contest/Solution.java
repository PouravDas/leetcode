package com.leetcode.test253.contest;

import java.util.Arrays;

class Solution {
  public int maxSum(int[] nums) {
    int max = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        String a = "" + nums[i];
        String b = "" + nums[j];
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();
        Arrays.sort(a_arr);
        Arrays.sort(b_arr);
        String aSorted = new String(a_arr);
        String bSorted = new String(b_arr);
        if(aSorted.charAt(aSorted.length() - 1) == bSorted.charAt(bSorted.length() - 1)) {
          max = Math.max(max,nums[i] + nums[j]);
        }
      }
    }
    return max;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.maxSum(new int[]{51,71,17,24,42});
  }
}
