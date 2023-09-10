package com.leetcode.test156.removeDuplicatesInArray;

//26. Remove Duplicates from Sorted Array (easy)
class Solution {
  public int removeDuplicates(int[] nums) {
    if(nums.length <= 1){
      return nums.length;
    }
    int curr = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[curr] != nums[i]) {
        nums[++curr] = nums[i];
      }
    }
    return curr + 1;
  }
}
