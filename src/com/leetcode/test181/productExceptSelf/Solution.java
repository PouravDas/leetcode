package com.leetcode.test181.productExceptSelf;

//238. Product of Array Except Self
class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int[] ans = new int[nums.length];
    for (int i = 0; i < ans.length; i++) {
      left[i] = i > 0 ? left[i - 1] * nums[i] : nums[i];
    }
    for (int i = ans.length - 1; i >= 0; i--) {
      right[i] = i < ans.length - 1 ? right[i + 1] * nums[i] : nums[i];
    }
    for (int i = 0; i < ans.length; i++) {
      int l = i > 0 ? left[i - 1] : 1;
      int r = i < nums.length - 1 ? right[i + 1] : 1;
      ans[i] = l * r;
    }
    return ans;
  }
  void print(int[] a){
    String st = "[";
    for(int i : a) st += i + ",";
    st += "]";
    System.out.println(st);
  }
}
