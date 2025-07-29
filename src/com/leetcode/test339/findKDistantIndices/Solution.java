package com.leetcode.test339.findKDistantIndices;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> ans = new ArrayList<>();
    int i = 0;
    int last = -1;
    while (i < nums.length) {
      if (nums[i] == key) {
        for (int j = ((i - k) <= last ? last + 1 : i - k); j <= (i + k >= nums.length ? nums.length - 1 : i + k); j++) {
          ans.add(j);
        }
        last = ans.get(ans.size()-1);
      }
      i++;
    }
    return ans;
  }
}
