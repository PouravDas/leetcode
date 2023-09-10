package com.leetcode.test159.permutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute (int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> input = new ArrayList<>();
    for (int n : nums)
      input.add(n);
    permute(input, new ArrayList<>(), result);
    return result;
  }

  private void permute (List<Integer> input, List<Integer> curr, List<List<Integer>> result) {
    if(input.isEmpty()){
      result.add(curr);
    }
    for (int i = 0; i < input.size(); i++) {
      List<Integer> newCur = new ArrayList<>(curr);
      newCur.add(input.get(i));
      List<Integer> newInput = new ArrayList<>(input);
      newInput.remove(i);
      permute(newInput,newCur,result);
    }
  }
}
