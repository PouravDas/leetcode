package com.leetcode.test300.find132pattern;

import java.util.ArrayDeque;

//using monotonic stack
public class Solution2 {
  public boolean find132pattern (int[] nums) {
    int min = Integer.MAX_VALUE;
    ArrayDeque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      int two = nums[i];
      while (!stack.isEmpty() && stack.peek()[0] <= two) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        int[] three = stack.peek();
        if (three[1] < three[0] && three[1] < two)
          return true;
      }
      stack.push(new int[] {two, min});
      min = Math.min(min, two);
    }
    return false;
  }

  public static void main (String[] args) {
    Solution2 s = new Solution2();
    s.find132pattern(new int[]{3,5,0,3,4});
  }
}
