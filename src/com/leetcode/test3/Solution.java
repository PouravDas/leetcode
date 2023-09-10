package com.leetcode.test3;

public class Solution {

  public int trap (int[] height) {
    int ans = 0;

    int[] leftLargest = new int[height.length];
    int[] rightLargest = new int[height.length];

    int leftL = 0;
    int rightR = 0;

    for (int i = 0; i < height.length; i++) {
      if (leftL < height[i]) {
        leftL = height[i];
      }

      leftLargest[i] = leftL;
    }
    for (int i = height.length - 1; i >= 0; i--) {
      if (rightR < height[i]) {
        rightR = height[i];
      }

      rightLargest[i] = rightR;
    }

    for (int i = 0; i < height.length; i++) {
      ans += Math.min(leftLargest[i], rightLargest[i]) - height[i];
    }

    return ans;
  }

  public static void main (String[] args) {

    // int[] height = { 4, 2, 0, 3, 2, 5 };
    // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Solution wt = new Solution();
    System.out.println(wt.trap(height));
  }
}
