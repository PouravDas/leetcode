package com.leetcode.test48.largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int largestRectangleArea (int[] heights) {

    int[] previousSmaller = new int[heights.length];
    int[] nextSmaller = new int[heights.length];

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        previousSmaller[i] = -1;

      } else {
        previousSmaller[i] = stack.peek();
      }
      stack.push(i);
    }

    stack.clear();
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextSmaller[i] = heights.length;

      } else {
        nextSmaller[i] = stack.peek();
      }
      stack.push(i);
    }

    int maxArea = 0;

    for (int i = 0; i < heights.length; i++) {
      int left = previousSmaller[i];
      int right = nextSmaller[i];
      int area = (right - left - 1) * heights[i];
      maxArea = Math.max(area, maxArea);
    }
    return maxArea;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});
  }
}
