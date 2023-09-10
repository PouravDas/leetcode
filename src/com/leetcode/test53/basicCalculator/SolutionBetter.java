package com.leetcode.test53.basicCalculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * first convert infix to postfix
 * <p>
 * logic for infix to postfix
 * when operand then print/add to the list
 * when operator then push to the stack (pop if higher precedence operator is present at top before pushing)
 * when open bracket just push if close bracket keep popping till open bracket.
 * <p>
 * then postfix expression can be easily evaluated
 */
public class SolutionBetter {
  public int calculate (String s) {
    Deque<String> stack = new ArrayDeque<>();
    List<String> postfix = new ArrayList<>();
    Input input = new Input(s);
    while (input.hasNext()) {
      String in = input.getNext();
      if (Character.isDigit(in.charAt(0))) {
        postfix.add(in);
      } else {
        if (in.charAt(0) == ')') {
          while (stack.peek().charAt(0) != '(') {
            postfix.add(stack.pop());
          }
          stack.pop();
        } else if (in.charAt(0) == '(') {
          stack.push(in);
        } else {
          while (!stack.isEmpty() && getPrecedence(in) <= getPrecedence(stack.peek())) {
            postfix.add(stack.pop());
          }
          stack.push(in);
        }
      }
    }
    while (!stack.isEmpty()) {
      postfix.add(stack.pop());
    }

    for (String in : postfix) {
      if (Character.isDigit(in.charAt(0))) {
        stack.push(in);
      } else {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        int ans = 0;
        switch (in.charAt(0)) {
          case '+':
            ans = a + b;
            break;
          case '-':
            ans = a - b;
            break;
          case '*':
            ans = a * b;
            break;
          case '/':
            ans = a / b;
        }
        stack.push("" + ans);
      }
    }

    return Integer.parseInt(stack.pop());
  }

  private int getPrecedence (String in) {
    switch (in) {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
      default:
        return -1;
    }
  }

  private static class Input {
    String st;
    int idx = 0;

    Input (String s) {
      st = s;
    }

    String getNext () {
      while (st.charAt(idx) == ' ') {
        idx++;
      }

      if (Character.isDigit(st.charAt(idx))) {
        String num = "";
        while (idx < st.length() && Character.isDigit(st.charAt(idx))) {
          num += st.charAt(idx++);
        }
        return num;
      }
      return "" + st.charAt(idx++);
    }

    boolean hasNext () {
      if (idx == st.length())
        return false;
      else
        return !st.substring(idx).trim().isBlank();
    }
  }

  public static void main (String[] args) {
    SolutionBetter s = new SolutionBetter();
    int ans = s.calculate("(1+(4+5+2)-3)+(6+8)");
    System.out.println(ans);
  }
}
