package com.leetcode.test32.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Solution3 {
  public List<List<Integer>> threeSum_fucked(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        int b = nums[j];
        if(set.contains(-1 * b)) {
         ans.add(Stream.of(a, b, -1 * (a + b)).sorted().toList());
        }
        set.add(a + b);
      }
    }
    return ans.stream().toList();
  }

  public int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums);
    int l = 0;
    int r = nums.length -1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if(sum == target) return new int[]{l,r};
      else if(sum > target) {
        r--;
      } else {
        l++;
      }
    }
    return null;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];
      int l = i + 1;
      int r = nums.length -1;
      while (l < r) {
        int b = nums[l];
        int c = nums[r];
        if(a + b + c == 0) {
          ans.add(List.of(a,b,c));
          break;
        }
        else if(a + b + c > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return ans.stream().toList();
  }
}
