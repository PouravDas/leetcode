package com.leetcode.test53.basicCalculator;

import java.util.ArrayDeque;
import java.util.Deque;

//#224
class Solution {
  public int calculate (String s) {

    Deque<String> stack = new ArrayDeque<>();
    int i = 0;

    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
        continue;
      }

      if (c == ')') {
        int result = 0;
        int num = 0;
        while (true) {
          String e = stack.pop();
          if (e.equals("("))
            break;

          if (Character.isDigit(e.charAt(0)))
            num = Integer.parseInt("" + e);

          else if (e.equals("+")) {
            result += num;
          } else if (e.equals("-")) {
            result -= num;
          }
        }

        if (result < 0) {
          if(!stack.isEmpty() && stack.peek().equals("-")) {
            stack.pop();
            stack.push("+");
          } else if(!stack.isEmpty() && stack.peek().equals("+")) {
            stack.pop();
            stack.push("-");
          } else {
            stack.push("-");
          }
        } else{
          if(!stack.isEmpty() && (stack.peek().equals("-") || stack.peek().equals("+"))) {

          } else {
            stack.push("+");
          }
        }
        stack.push("" + Math.abs(result));
      } else {
        if (Character.isDigit(c)) {
          int number = 0;
          while (Character.isDigit(c) && i < s.length()) {
            c = s.charAt(i);
            if(!Character.isDigit(c))
              break;

            number = number * 10 + Integer.parseInt("" + c);
            i++;
          }
          if(stack.isEmpty() || stack.peek().equals("(")){
            stack.push("+");
          }
          stack.push("" + number);
          continue;
        } else {
          stack.push("" + c);
        }
      }
      i++;
    }

    int result = 0;
    int num = 0;
    while (!stack.isEmpty()) {
      String e = stack.pop();

      if (e.charAt(0) >= '0' && e.charAt(0) <= '9')
        num = Integer.parseInt("" + e);

      else if (e.equals("+")) {
        result += num;
        num = 0;
      } else if (e.equals("-")) {
        result -= num;
        num = 0;
      }
    }

    return result;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    String equ = "1-(     -2)";
    //equ = "(1+(4+5+2)-3)+(6+8)";
    equ = "(5-(1+(5)))";
    int ans = s.calculate(equ);
    System.out.println(ans);
  }
}
