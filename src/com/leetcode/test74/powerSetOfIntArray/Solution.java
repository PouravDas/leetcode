package com.leetcode.test74.powerSetOfIntArray;

import java.util.*;
import java.util.stream.Collectors;

//#78
class Solution {
  public List<List<Integer>> subsets (int[] nums) {
    Set<List<Integer>> powSet = new HashSet<>();
    powerSet(powSet, new ArrayList<>(), nums, 0);
    return powSet.stream().collect(Collectors.toList());
  }

  private void powerSet (Set<List<Integer>> powSet, List<Integer> list, int[] nums, int i) {
    if(i == nums.length){
      list.sort(Comparator.naturalOrder());
      powSet.add(list);
    }
    else {
      powerSet(powSet, list, nums, i + 1);
      List<Integer> newList = new ArrayList<>(list);
      newList.add(nums[i]);
      powerSet(powSet, newList, nums, i + 1);
    }
  }


  Set<List<Integer>> ans = new HashSet<>();
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    subset(nums, 0, new ArrayList<>());
    return new ArrayList<>(ans);
  }

  void subset(int[] nums, int i, List<Integer> curr) {
    if(i == nums.length) {
      ArrayList<Integer> e = new ArrayList<>(curr);
      Collections.sort(e);
      ans.add(e);
      return;
    }

    subset(nums, i + 1, curr);
    curr.add(nums[i]);
    subset(nums, i + 1, curr);
    curr.remove(curr.size() - 1);
  }
}
