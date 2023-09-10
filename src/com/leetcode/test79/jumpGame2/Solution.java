package com.leetcode.test79.jumpGame2;

class Solution {
  public int jump (int[] nums) {
    int jumps = 0;
    int idx = 0;

    while (idx < nums.length) {
      if (idx == nums.length - 1) {
        return jumps;
      }
      int val = nums[idx];
      if (idx + val >= nums.length - 1)
        return jumps + 1;
      int max = Integer.MIN_VALUE;
      int newIdx = 0;
      for (int i = idx + val; i > idx; i--) {
        int newMax = Math.max(i + nums[i], max);
        if (newMax > max) {
          newIdx = i;
          max = newMax;
        }
      }
      idx = newIdx;
      jumps++;
    }

    return jumps;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.jump(new int[] {2, 3, 1, 1, 4});
    System.out.println(ans);
  }
}
