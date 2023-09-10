package com.leetcode.test87.evaluateReversePolishNotation;

import java.util.Stack;

// # 150
public class Solution {
  public int evalRPN (String[] tokens) {

    Stack<Integer> stack = new Stack<>();

    for (String st : tokens) {

      if (Character.isDigit(st.charAt(st.length() - 1))) {
        stack.push(Integer.parseInt(st));
      } else {
        int b = stack.pop();
        int a = stack.pop();

        int ans = 0;
        if (st.charAt(0) == '+') {
          ans = a + b;
        } else if (st.charAt(0) == '-') {
          ans = a - b;
        } else if (st.charAt(0) == '*') {
          ans = a * b;
        } else if (st.charAt(0) == '/') {
          ans = a / b;
        }
        stack.push(ans);
      }
    }

    return stack.peek();
  }
}
