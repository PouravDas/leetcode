package com.leetcode.test30.majorityElementInSubarray;

import java.util.HashMap;
import java.util.Map;

class MajorityChecker {

  int arr[];

  public MajorityChecker(int[] arr) {
    this.arr = arr;
  }

  public int query (int left, int right, int threshold) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = left; i <= right; i++) {

      int el = arr[i];
      if (map.containsKey(el)) {
        map.put(el, map.get(el) + 1);
      } else {
        map.put(el, 1);
      }
      if (map.get(el) >= threshold)
        return el;
    }

    return -1;
  }
}

/**
 * Your MajorityChecker object will be instantiated and called as such: MajorityChecker obj = new
 * MajorityChecker(arr); int param_1 = obj.query(left,right,threshold);
 */
