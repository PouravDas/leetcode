package com.leetcode.test54.basicCalculator2;

import java.util.ArrayDeque;
import java.util.Deque;

//227
class Solution {
  public int calculate (String s) {

    Deque<String> stack = new ArrayDeque<>();
    stack.push("+");

    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
        continue;
      } else if (Character.isDigit(c)) {
        int num = 0;
        while (i < s.length()) {
          c = s.charAt(i);
          if (!Character.isDigit(c)) {
            break;
          }

          num = num * 10 + Integer.parseInt("" + c);
          i++;
        }
        stack.push("" + num);
        continue;
      } else if (c == '-' || c == '+') {
        stack.push("" + c);
        i++;
      } else if (c == '*' || c == '/') {
        int a = Integer.parseInt(stack.pop());

        boolean isMul = c == '*';
        //next number
        int next = 0;
        i++;
        while (i < s.length()) {
          c = s.charAt(i);
          if (c == ' ') {
            i++;
            continue;
          }
          c = s.charAt(i);
          if (!Character.isDigit(c)) {
            break;
          }

          next = next * 10 + Integer.parseInt("" + c);
          i++;
        }

        if (isMul)
          stack.push("" + (a * next));
        else
          stack.push("" + (a / next));
        continue;
      }
    }

    int result = 0;
    int num = 0;
    while (!stack.isEmpty()) {
      String e = stack.pop();
      if (Character.isDigit(e.charAt(0))) {
        num = Integer.parseInt(e);
      } else if (e.charAt(0) == '-') {
        result -= num;
      } else if (e.charAt(0) == '+') {
        result += num;
      }
    }

    return result;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.calculate("3+2*2");
  }
}
