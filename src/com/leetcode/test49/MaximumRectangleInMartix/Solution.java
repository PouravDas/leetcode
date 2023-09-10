package com.leetcode.test49.MaximumRectangleInMartix;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int maximalRectangle (char[][] matrix) {
    int maxArea = 0;

    for (int i = 0; i < matrix.length; i++) {
      int[] height = new int[matrix[0].length];

      for (int j = 0; j < matrix[0].length; j++) {

        int h = i;
        while (h < matrix.length && matrix[h][j] == '1') {
          height[j]++;
          h++;
        }
      }

      Deque<Integer> stack = new ArrayDeque<>();

      int[] previousSmaller = new int[matrix[0].length];
      int[] nextSmaller = new int[matrix[0].length];

      for (int j = 0; j < height.length; j++) {
        while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
          stack.pop();
        }
        if (stack.isEmpty())
          previousSmaller[j] = -1;
        else
          previousSmaller[j] = stack.peek();
        stack.push(j);
      }

      stack.clear();
      for (int j = height.length - 1; j >= 0; j--) {
        while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
          stack.pop();
        }
        if (stack.isEmpty())
          nextSmaller[j] = height.length;
        else
          nextSmaller[j] = stack.peek();
        stack.push(j);
      }

      for (int j = 0; j < height.length; j++) {
        maxArea = Math.max(maxArea, height[j] * (nextSmaller[j] - previousSmaller[j] - 1));
      }
    }

    return maxArea;
  }
}
