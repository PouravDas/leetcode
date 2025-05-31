package com.leetcode.test326.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  List<List<Integer>> ans =new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
    backtrack(nums, 0, new ArrayList<>());
    return ans;
  }

  void backtrack(int[] nums, int start, List<Integer> curr) {
    System.out.println(curr);
    ans.add(new ArrayList<>(curr));//[]
    for (int i = start; i < nums.length; i++) {
      curr.add(nums[i]);//[1]
      backtrack(nums, i + 1, curr);
      curr.remove(curr.size() - 1);
    }
  }
}
