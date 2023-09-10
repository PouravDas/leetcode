package com.leetcode.test179.sortColors;

//75. Sort Colors
class Solution {
  public void sortColors (int[] nums) {
    if (nums == null)
      return;

    int start = 0;
    int end = nums.length - 1;
    int curr = 0;

    while (curr < end) {
      if (nums[curr] == 0) {
        swap(curr, start, nums);
        start++;
        curr++;
      } else if (nums[curr] == 2) {
        swap(curr, end, nums);
        end--;
      } else {
        curr++;
      }
    }
  }

  private void swap (int i, int j, int[] nums) {
    if (i == j)
      return;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.sortColors(new int[] {2, 0, 1});
  }
}
