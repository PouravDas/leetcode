package com.leetcode.test75.letterCasePermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<String> letterCasePermutation(String s) {

    Set<String> list = new HashSet<>();
    permute(list,s,0);
    return list.stream().toList();
  }

  private void permute (Set<String> list, String s, int i) {
    if(i == s.length()){
      list.add(s);
    } else {
      char c = s.charAt(i);
      String end = i < s.length() - 1 ? s.substring(i + 1, s.length()) : "";
      permute(list,s.substring(0,i) + (""+c).toLowerCase() + end,i + 1);
      permute(list,s.substring(0,i) + (""+c).toUpperCase() + end,i + 1);
    }
  }
}
