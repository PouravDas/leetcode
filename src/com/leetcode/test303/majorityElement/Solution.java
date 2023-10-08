package com.leetcode.test303.majorityElement;

import java.util.ArrayList;
import java.util.List;

//229. Majority Element II
class Solution {
  public List<Integer> majorityElement (int[] nums) {
    List<Integer> ans = new ArrayList<>();

    int can1 = Integer.MAX_VALUE, can2 = Integer.MAX_VALUE;
    int count1 = 0, count2 = 0;
    for (int n : nums) {
      if (n == can1) {
        count1++;
      } else if (n == can2) {
        count2++;
      } else if (count1 == 0) {
        can1 = n;
        count1++;
      } else if (count2 == 0) {
        can2 = n;
        count2++;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int n : nums) {
      if (can1 == n) {
        count1++;
      } else if (can2 == n) {
        count2++;
      }
    }
    if (count1 > nums.length / 3) {
      ans.add(can1);
    }
    if (count2 > nums.length / 3) {
      ans.add(can2);
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.majorityElement(new int[] {2, 1, 1, 3, 1, 4, 5, 6});
  }
}
