package com.leetcode.test35.fourSum2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int fourSumCount (int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums3.length; i++) {
      for (int j = 0; j < nums4.length; j++) {
        int sum = nums3[i] + nums4[j];
        if (!map.containsKey(sum)) {
          map.put(sum, 0);
        }
        map.put(sum, map.get(sum) + 1);
      }
    }

    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int sum = nums1[i] + nums2[j];
        int need = -sum;
        
        if(map.containsKey(need)) {
          ans += map.get(need);
        }
      }
    }

    return ans;
  }
}
