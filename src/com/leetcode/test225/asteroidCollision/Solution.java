package com.leetcode.test225.asteroidCollision;

import java.util.ArrayDeque;

class Solution {
  public int[] asteroidCollision (int[] asteroids) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (int a : asteroids) {
      if (a < 0) {
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < a * -1) {
          stack.pop();
        }
        if (stack.isEmpty()) {
          stack.push(a);
        } else if (stack.peek() < 0) {
          stack.push(a);
        } else if (stack.peek() == a * -1) {
          stack.pop();
        }
      } else {
        stack.push(a);
      }
    }
    int[] ans = new int[stack.size()];
    for (int i = ans.length - 1; i > -1; i--) {
      ans[i] = stack.pop();
    }
    return ans;
  }
}
