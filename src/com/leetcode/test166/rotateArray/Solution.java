package com.leetcode.test166.rotateArray;

//189. Rotate Array
class Solution {
  public void rotate (int[] nums, int k) {
    int[] arr = new int[nums.length];
    int idx = 0;
    k = k % nums.length;
    for (int i = nums.length - k; i < nums.length; i++) {
      arr[idx++] = nums[i];
    }
    for (int i = 0; i < nums.length - k; i++) {
      arr[idx++] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = arr[i];
    }
  }
}
