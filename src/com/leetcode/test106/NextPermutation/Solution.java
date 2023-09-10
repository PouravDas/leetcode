package com.leetcode.test106.NextPermutation;

import java.util.PriorityQueue;

//#31
class Solution {
  public void nextPermutation (int[] nums) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int idx = nums.length - 1;
    while (idx > 0) {
      if (nums[idx - 1] < nums[idx]) {
        queue.add(nums[idx]);
        int targetIdx = idx - 1;
        int target = nums[idx - 1];
        while (!queue.isEmpty()) {
          int el = queue.poll();
          if (el > target) {
            nums[targetIdx] = el;
            nums[idx] = target;
            target = Integer.MAX_VALUE;
          } else {
            nums[idx] = el;
          }
          idx++;
        }
        break;
      } else {
        queue.add(nums[idx]);
      }
      idx--;
    }
    if (idx == 0) {
      queue.add(nums[idx]);
      for (int i = 0; i < nums.length; i++) {
        nums[i] = queue.poll();
      }
    }
    System.out.println(nums);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.nextPermutation(new int[] {3, 2, 1});
  }
}
