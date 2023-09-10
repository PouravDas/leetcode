package com.leetcode.test246.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. Letter Combinations of a Phone Number
class Solution {
  Map<Integer, List<Character>> map = new HashMap<>();

  {
    map.put(0, List.of(' '));
    map.put(2, List.of('a', 'b', 'c'));
    map.put(3, List.of('d', 'e', 'f'));
    map.put(4, List.of('g', 'h', 'i'));
    map.put(5, List.of('j', 'k', 'l'));
    map.put(6, List.of('m', 'n', 'o'));
    map.put(7, List.of('p', 'q', 'r', 's'));
    map.put(8, List.of('t', 'u', 'v'));
    map.put(9, List.of('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations (String digits) {
    List<String> ans = new ArrayList<>();
    if(digits == null || digits.isBlank()) return ans;
    findCombo(0, digits, "", ans);
    return ans;
  }

  private void findCombo (int i, String digits, String s, List<String> ans) {
    if (i == digits.length() - 1) {
      ans.add(s);
      return;
    }
    map.get(Integer.parseInt("" + digits.charAt(i))).forEach(c -> {
      findCombo(i + 1, digits, s + c, ans);
    });
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    List<String> ans = s.letterCombinations("23");
    System.out.println();
  }
}
