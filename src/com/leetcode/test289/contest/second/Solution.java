package com.leetcode.test289.contest.second;

import java.util.Collections;
import java.util.List;

//2860. Happy Students
class Solution {
  public int countWays (List<Integer> nums) {
    Collections.sort(nums);
    int ans = nums.get(0) > 0 ? 1 : 0;
    for (int i = 0; i < nums.size(); i++) {
      int sel = i + 1;
      if (sel > nums.get(i) && (sel == nums.size() || sel < nums.get(i + 1)))
        ans++;
    }
    return ans;
  }
}

