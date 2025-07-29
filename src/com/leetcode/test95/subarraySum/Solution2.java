package com.leetcode.test95.subarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    int ans = 0;
    int prefSum = 0;
    for (int n : nums) {
      prefSum += n;
      if (map.containsKey(prefSum - k)) {
        ans += map.get(prefSum - k);
      }
      map.compute(prefSum, (key, val) -> val == null ? 1 : val + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int i = s.subarraySum(new int[]{10, 15, -5, 15, -10, 5}, 5);
    System.out.println(i);
  }
}
