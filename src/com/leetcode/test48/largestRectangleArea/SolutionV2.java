package com.leetcode.test48.largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Stack;

public class SolutionV2 {
  public int largestRectangleArea(int[] heights) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int[] prevSmall = new int[heights.length];
    int[] nextSmall = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        prevSmall[i] = -1;
      } else {
        prevSmall[i] = stack.peek();
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextSmall[i] = heights.length;
      } else {
        nextSmall[i] = stack.peek();
      }
      stack.push(i);
    }
    int ans = 0;
    for (int i = 0; i < heights.length; i++) {
      int area = heights[i] * (nextSmall[i] - prevSmall[i] - 1);
      ans = Math.max(area, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    SolutionV2 s = new SolutionV2();
    s.largestRectangleArea(new int[]{2,4});
  }

  public int maximalSquare(char[][] matrix) {
    int[][] mat = new int[matrix.length][matrix[0].length];

    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        mat[i][j] = matrix[i][j] == '0' ? 0 : 1;
        if(mat[i][j] == 1) {
          int l = j > 0 ? mat[i][j -1] : 0;
          int t = i > 0 ? mat[i - 1][j] : 0;
          int d = i > 0 && j > 0 ? mat[i-1][j-1] : 0;
          int min = Math.min(Math.min(l,t), d);
          mat[i][j] = min + 1;
          max = Math.max(max, mat[i][j]);
        }
      }
    }
    return max * max;
  }

  public String[] divideString(String s, int k, char fill) {
    int len = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
    String[] ans = new String[s.length() / k];
    for (int i = 0; i < len; i++) {
      if(i != len -1)
        ans[i] = s.substring(i * k, (i +1) * k);
      else
        ans[i] = s.substring(i * k);
    }
    while(ans[len - 1].length() != k) {
      ans[len - 1] = ans[len - 1] + fill;
    }
    return ans;
  }
}
