package com.leetcode.test34.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<List<Integer>> fourSum (int[] nums, int target) {

    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {

      for (int j = i + 1; j < nums.length - 1; j++) {
        int k = j + 1;
        int l = nums.length - 1;

        while (k < l) {
          long a = nums[i];
          long b = nums[j];
          long c = nums[k];
          long d = nums[l];

          long sum = a + b + c + d;

          if (sum == target) {
            set.add(List.of((int) a, (int) b, (int) c, (int) d));
            k++;
            l--;
          } else if (sum < target) {
            k++;
          } else {
            l--;
          }
        }
      }
    }

    return new ArrayList<>(set);
  }

  public static void main (String[] args) {
    long a = 1000000000;
    long s = a + a + a + a;
    System.out.println(s);
  }
}
