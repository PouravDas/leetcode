package com.grab;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Hafiz Azmi  to  Everyone 1:04 PM
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "(()[]{})"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 *
 *
 * ))(
 *
 * )(())(
 *
 */
public class Test {
  public static boolean isValidBrackets (String input) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char c : input.toCharArray()) {
      switch (c) {
        case '(':
        case '[':
        case '{':
          stack.push(c);
          break;
        case ')':
          if (stack.isEmpty()) {
            return false;
          }
          char elem = stack.pop();
          if (elem != '(') {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty()) {
            return false;
          }
          elem = stack.pop();
          if (elem != '[') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty()) {
            return false;
          }
          elem = stack.pop();
          if (elem != '{') {
            return false;
          }
          break;
        default:
          return false;
      }
    }
    if (!stack.isEmpty())
      return false;
    return true;
  }

  public static int findOperations(String invalidParams) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('(', 0);
    map.put('[', 0);
    map.put('{', 0);
    map.put(')', 0);
    map.put('}', 0);
    map.put(']', 0);
    for (char c : invalidParams.toCharArray()) {
      map.compute(c, (k,v) -> v == null ? 1 : v + 1);
    }
    int count_openSimple = 0;
    int count_closeSimple = 0;
    int count_openSquare = 0;
    int count_closeSquare = 0;
    int count_openCurly = 0;
    int count_closeCurly = 0;

    if(map.get('(') < map.get(')')) {
      count_closeSimple = map.get(')') - map.get('(');
    } else if (map.get('(') > map.get(')')) {
      count_openSimple = map.get('(') - map.get(')');
    }

    if(map.get('{') < map.get('}')) {
      count_closeSimple = map.get('}') - map.get('{');
    } else if (map.get('{') > map.get('}')) {
      count_openSimple = map.get('{') - map.get('}');
    }

    if(map.get('[') < map.get(']')) {
      count_closeSimple = map.get(']') - map.get('[');
    } else if (map.get('(') > map.get(')')) {
      count_openSimple = map.get('(') - map.get(')');
    }
    return 0;
  }

  public static void main (String[] args) {
    System.out.println(Test.isValidBrackets("()"));
    System.out.println(Test.isValidBrackets("(()[]{})"));
    System.out.println(Test.isValidBrackets("(]"));
  }
}
