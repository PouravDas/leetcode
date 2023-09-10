package com.leetcode.test105.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

//#20 easy stack
public class Solution {
  public boolean isValid (String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (stack.isEmpty()) {
        if (getRev(c) == c) {
          stack.push(c);
        } else {
          return false;
        }
      } else {
        if (getRev(c) == c) {
          stack.push(c);
        } else {
          if (!stack.isEmpty() && getRev(c) == stack.peek()) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }

  private char getRev (char c) {
    switch (c) {
      case ')':
        return '(';
      case '}':
        return '{';
      case ']':
        return '[';
      default:
        return c;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.isValid("()[]{}");
  }
}
