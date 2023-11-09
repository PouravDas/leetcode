package com.leetcode.test316.numFactoredBinaryTrees;

import java.util.*;

class Solution {
  int MOD = 1_000_000_000 + 7;

  public int numFactoredBinaryTrees (int[] arr) {
    Arrays.sort(arr);
    long ans = 0;
    Set<Integer> set = new HashSet<>();
    Map<Integer, Long> dp = new HashMap<>();
    for (int i : arr) {
      set.add(i);
      dp.put(i, 1L);
    }
    for (int i = 0; i < arr.length; i++) {
      int n = arr[i];
      long size = 1;
      for (int j = 0; j < i; j++) {
        int next = arr[j];
        if (next > Math.sqrt(n))
          break;
        if (n % next == 0 && set.contains(n / next)) {
          long ways = 1;
          ways *= dp.get(next);
          ways *= dp.get(n / next);
          if (next != n / next)
            size += (ways * 2);
          else
            size += ways;
        }
      }
      size %= MOD;
      dp.put(n, size);
      ans = (ans + size) % MOD;
    }
    return (int) ans;
  }
}
