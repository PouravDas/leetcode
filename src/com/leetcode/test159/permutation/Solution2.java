package com.leetcode.test159.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//46. Permutations
public class Solution2 {
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
    permute(list, 0);
    return ans;
  }

  void permute(List<Integer> list, int start) {
    if (start == list.size()) {
      ans.add(new ArrayList<>(list));
    }
    for (int i = start; i < list.size(); i++) {
      Collections.swap(list, start, i);
      permute(list, i + 1);
      Collections.swap(list, i, start);
    }
  }
}
