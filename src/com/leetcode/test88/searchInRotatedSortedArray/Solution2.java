package com.leetcode.test88.searchInRotatedSortedArray;

public class Solution2 {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target) return mid;

      if (target > nums[mid]) {
        if(target <= nums[r] || nums[mid] > nums[r] ) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else {
        if(target >= nums[l] || nums[mid] <= nums[l]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return -1;
  }
}
