package com.leetcode.test173.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
class Solution {
  public List<String> generateParenthesis (int n) {
    List<String> list = new ArrayList<>();
    generateParenthesis("", 0, 0, n, list);
    return list;
  }

  private void generateParenthesis (String st, int open, int close, int target, List<String> list) {
    if (open > target)
      return;
    if (close == target) {
      list.add(st);
    } else if (open == close) {
      generateParenthesis(st + "(", open + 1, close, target, list);
    } else if (open > close) {
      generateParenthesis(st + "(", open + 1, close, target, list);
      generateParenthesis(st + ")", open, close + 1, target, list);
    }
  }
}
