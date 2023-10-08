package com.leetcode.test294.minOperations;

//1658. Minimum Operations to Reduce X to Zero
//
class Solution {
  public int minOperations (int[] nums, int x) {
    int totalSum = 0;
    for (int n : nums)
      totalSum += n;
    if(totalSum < x) return -1;
    if(totalSum == x) return nums.length;
    //System.out.println("total sum = " + totalSum);
    int start = 0;
    int end = 0;
    int currSum = 0;
    int max = Integer.MIN_VALUE;
    while (end < nums.length) {
      currSum += nums[end++];
      //System.out.println("currSum = " + currSum);
      //System.out.println("start = " + start + " end = " + end);
      if (totalSum - currSum == x) {
        max = Math.max(max, end - start);
      }
      while (totalSum - currSum < x && start < nums.length) {
        currSum -= nums[start++];
        //System.out.println("currSum = " + currSum);
        //System.out.println("start = " + start + " end = " + end);
        if (totalSum - currSum == x) {
          max = Math.max(max, end - start);
        }
      }
    }
    if (max == Integer.MIN_VALUE)
      return -1;
    else
      return nums.length - max;
  }
}
