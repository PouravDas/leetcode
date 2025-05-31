package com.leetcode.test326.subsets;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
public class Solution {
  List<List<Integer>> ans =new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> curr = new ArrayList<>();
    subset(nums, 0, curr);
    return ans;
  }

  void subset(int[] nums, int i, List<Integer> curr) {
    if (i == nums.length) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    curr.add(nums[i]);
    subset(nums, i + 1, curr);
    curr.remove(curr.size() - 1);
    subset(nums, i + 1, curr);
  }
}
