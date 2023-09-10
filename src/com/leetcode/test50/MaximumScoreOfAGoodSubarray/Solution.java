package com.leetcode.test50.MaximumScoreOfAGoodSubarray;

class Solution {
  public int maximumScore (int[] nums, int k) {
    int maxScore = nums[k];
    int min = Integer.MAX_VALUE;

    int i = k;
    int j = k;

    while (i > 0 || j < nums.length - 1) {
      if (i == 0)
        j++;

      else if (j == nums.length - 1)
        i--;

      else if (nums[i - 1] < nums[j + 1])
        j++;
      else
        i--;

      min = Math.min(min, Math.min(nums[i], nums[j]));
      maxScore = Math.max(maxScore, (j - i + 1) * min);
    }

    return maxScore;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.maximumScore(new int[] {1, 4, 3, 7, 4, 5}, 3);
    System.out.println(ans);
  }
}
