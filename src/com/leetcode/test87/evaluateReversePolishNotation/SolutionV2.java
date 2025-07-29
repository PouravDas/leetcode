package com.leetcode.test87.evaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Stack;

public class SolutionV2 {
  public int evalRPN(String[] tokens) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (String t : tokens) {
      if (isOperator(t)) {
        int b = stack.pop();
        int a = stack.pop();
        int ans = perform(a, b, t);
        stack.push(ans);
      } else {
        stack.push(Integer.parseInt(t));
      }
    }
    return stack.pop();
  }

  private int perform(int a, int b, String t) {
    return switch (t) {
      case "*" -> a * b;
      case "/" -> a / b;
      case "+" -> a + b;
      case "-" -> a - b;
      default -> 0;
    };
  }

  private boolean isOperator(String t) {
    return switch (t) {
      case "*", "/", "+", "-" -> true;
      default -> false;
    };
  }
}
