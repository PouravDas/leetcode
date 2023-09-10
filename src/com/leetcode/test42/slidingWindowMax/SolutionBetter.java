package com.leetcode.test42.slidingWindowMax;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * using deque
 * maintain the deque in descending order
 * remove the useless elements before adding in the deque
 *    i.e. remove all smaller elements in the deque before adding a new element
 * when window slides remove the element from the head if it is that element.
 */
public class SolutionBetter {
  public int[] maxSlidingWindow (int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    int resIdx = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      if (!deque.isEmpty()) {
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
          deque.pollLast();
        }
      }
      deque.offerLast(i);
    }
    res[resIdx++] = nums[deque.peekFirst()];
    for (int winStart = 0, winEnd = k; winEnd < nums.length; winEnd++, winStart++) {
      if (deque.peekFirst() == winStart) {
        deque.pollFirst();
      }
      if (!deque.isEmpty()) {
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[winEnd]) {
          deque.pollLast();
        }
      }
      deque.offerLast(winEnd);
      res[resIdx++] = nums[deque.peekFirst()];
    }
    return res;
  }
}
