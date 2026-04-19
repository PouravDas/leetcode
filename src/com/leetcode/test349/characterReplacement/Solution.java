package com.leetcode.test349.characterReplacement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
  public int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int l = 0;
    int r = 0;
    int ans = 0;

    while (r < s.length()) {
      char c = s.charAt(r++);
      map.compute(c, (key, val) -> val != null ? val + 1 : 1);
      int[] status = getExtra(map);
      int extra = status[0];
      int total = status[1];
      if (extra <= k) {
        ans = Math.max(ans, total);
      } else {
        while (l <= r) {
          char remove = s.charAt(l++);
          map.compute(remove, (key, val) -> val != 1 ? val - 1 : null);
          status = getExtra(map);
          if (status[0] <= k) break;
        }
      }
    }
    return ans;
  }

  int[] getExtra(Map<Character, Integer> map) {
    AtomicInteger total = new AtomicInteger();
    AtomicInteger max = new AtomicInteger();

    map.forEach((k, v) -> {
      max.set(Math.max(max.get(), v));
      total.set(total.get() + v);
    });
    int extra = total.get() - max.get();
    return new int[]{extra, total.get()};
  }

  public int characterReplacement_(String s, int k) {

    int ans = 0;
    int max = 0;
    int[] count = new int[26];
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      count[c - 'A']++;
      max = Math.max(max, count[c - 'A']);
      if(right - left + 1 - max <= k) {
        ans = Math.max(ans, right - left + 1);
      }
      else {
        while (right - left + 1 - max > k) {
          count[s.charAt(left++) - 'A']--;
        }
      }
    }
    return ans;
  }
}
