package com.leetcode.test293.maxSumTwoNoOverlap;

//1031. Maximum Sum of Two Non-Overlapping Subarrays
//not solved yet
class Solution {
  public int maxSumTwoNoOverlap (int[] nums, int firstLen, int secondLen) {
    int left = 0, right = 0;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    while (right - left < firstLen) {
      sum += nums[right++];
    }
    while (right < nums.length) {
      if (left != 0 && left >= secondLen) {
        int leftMax = maxSum(nums, secondLen, 0, left - 1);
        max = Math.max(max, leftMax + sum);
      }
      if (nums.length - right >= secondLen) {
        int rightMax = maxSum(nums, secondLen, right, nums.length - 1);
        max = Math.max(max, rightMax + sum);
      }
      sum -= nums[left++];
      sum += nums[right++];
    }
    return max;
  }

  int maxSum (int[] nums, int len, int from, int to) {
    int left = from, right = from;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    while (right - left < len) {
      sum += nums[right++];
    }
    max = Math.max(max,sum);
    while (right <= to) {
      sum -= nums[left++];
      sum += nums[right++];
      max = Math.max(max,sum);
    }
    return max;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8},3,4);
    ans = s.maxSumTwoNoOverlap(new int[]{1,0,1},1,1);
    ans = s.maxSumTwoNoOverlap(new int[]{11,13,12,17,17,19,1,14,4,7,4,8,4},10,2);
    System.out.println(ans);
  }
}
