package com.leetcode.test150.gfg.minimumPlatforms;

import java.util.Arrays;

public class Solution {
  static int findPlatform (int arr[], int dep[], int n) {
    int count = 0, max = 0, a = 0, d = 0;
    Arrays.sort(arr);
    Arrays.sort(dep);
    while (a < n && d < n) {
      int arrive = arr[a];
      int depart = dep[d];
      if (arrive == depart) {
        a++;
        d++;
      } else if (arrive <= depart) {
        count++;
        a++;
      } else {
        count--;
        d++;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
