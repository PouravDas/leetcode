package com.leetcode.test42.slidingWindowMax;

import java.util.TreeMap;

//#239
public class Solution {
  public int[] maxSlidingWindow (int[] nums, int k) {

    int[] ans = new int[nums.length - k + 1];
    int idx = 0;
    TreeMap<Integer, Integer> queue = new TreeMap<>();

    int left = 0;
    int right = k;

    for (int i = 0; i < k; i++) {
      add(queue, nums[i]);
    }

    ans[idx] = queue.lastKey();
    idx++;

    while (right < nums.length) {
      remove(queue, nums[left]);
      left++;
      add(queue, nums[right]);
      right++;
      ans[idx] = queue.lastKey();
      idx++;
    }

    return ans;
  }

  private void remove (TreeMap<Integer, Integer> queue, int i) {
    queue.compute(i, (k, v) -> {
      if (v == 1) {
        return null;
      } else {
        return v - 1;
      }
    });
  }

  private void add (TreeMap<Integer, Integer> queue, int i) {
    queue.compute(i, (k, v) -> {
      if (v != null) {
        return v + 1;
      } else {
        return 1;
      }
    });
  }
}
