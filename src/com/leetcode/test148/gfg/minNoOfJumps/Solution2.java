package com.leetcode.test148.gfg.minNoOfJumps;

// working
public class Solution2 {
  static int minJumps (int[] arr) {
    if (arr.length == 1) {
      return 0;
    }
    if (arr[0] == 0) {
      return -1;
    }
    int steps = arr[0];
    int jumps = 1;
    int maxReach = arr[0];

    for (int i = 1; i < arr.length - 1; i++) {
      steps--;
      maxReach = Math.max(maxReach, arr[i] + i);
      if (steps == 0) {
        if (maxReach > i) {
          steps = maxReach - i;
          jumps++;
        } else {
          return -1;
        }
      }
    }
    return jumps;
  }
}
