package com.leetcode.test327.subsetsWithDup;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. Subsets II
public class Solution {
  List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    subset(nums, 0, new ArrayList<>());
    return ans;
  }

  public void subset(int[] nums, int start, List<Integer> curr) {
    ans.add(new ArrayList<>(curr));
    System.out.println(curr);
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      curr.add(nums[i]);
      subset(nums, i + 1, curr);
      curr.remove(curr.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.subsetsWithDup(new int[]{1, 2, 3});
  }
}
