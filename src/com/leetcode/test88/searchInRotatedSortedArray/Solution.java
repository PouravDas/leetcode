package com.leetcode.test88.searchInRotatedSortedArray;

// # 33
public class Solution {
  public int search (int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;
    int mind = nums.length / 2;

    while (start <= end) {
      if (nums[mind] == target) {
        return mind;
      } else if (nums[start] == target) {
        return start;
      } else if (nums[end] == target) {
        return end;
      }

      if (target < nums[mind]) {
        if (inLeftSide(target, nums[start], nums[mind])) {
          end = mind - 1;
        } else {
          start = mind + 1;
        }
      } else {
        if (!inRightSide(target, nums[mind], nums[end])) {
          end = mind - 1;
        } else {
          start = mind + 1;
        }
      }

      mind = (start + end) / 2;
    }

    return -1;
  }

  private boolean inLeftSide (int target, int start, int mind) {
    return (target < start && start > mind) || (target > start && start < mind);
  }

  private boolean inRightSide (int target, int mind, int end) {
    return (target < end && end > mind) || (target > end && end < mind);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.search(new int[] {2, 3, 4, 5, 6, 7, 8, 9, 1}, 9);
    System.out.println(ans);
  }
}
