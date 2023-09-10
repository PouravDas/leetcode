package com.leetcode.test55.expressionAddOperators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

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

  public List<String> addOperators (String num, int target) {

    List<String> ans = new ArrayList<>();
    String str = num.substring(0, 1);
    List<String> list = new ArrayList<>();
    allPossible(list, str, num, 1, str.equals("0"));
    for (String s : list) {
      if (calculate(s) == target)
        ans.add(s);
    }
    return ans;
  }

  public void allPossible (List<String> ans, String str, String num, int i, boolean wasZero) {
    if (i == num.length()) {
      ans.add(str);
      return;
    }
    char c = num.charAt(i);
    boolean isZero = c == '0';

    if (!wasZero)
      allPossible(ans, str + c, num, i + 1, isZero);
    allPossible(ans, str + '*' + c, num, i + 1, isZero);
    allPossible(ans, str + '-' + c, num, i + 1, isZero);
    allPossible(ans, str + '+' + c, num, i + 1, isZero);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.addOperators("00", 0);
  }


  private class SolutionCopy {
    public List<String> addOperators(String num, int target) {
      List<String> rst = new ArrayList<String>();
      if(num == null || num.length() == 0) return rst;
      helper(rst, "", num, target, 0, 0, 0);
      return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
      if(pos == num.length()){
        if(target == eval)
          rst.add(path);
        return;
      }
      for (int i = pos; i < num.length(); i++){
        if(i != pos && num.charAt(pos) == '0') break;
        long cur = Long.parseLong(num.substring(pos, i + 1));
        if(pos == 0){
          helper(rst, path + cur, num, target, i + 1, cur, cur);
        }
        else{
          helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

          helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

          helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
        }
      }
    }
  }
}


