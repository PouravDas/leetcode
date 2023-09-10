package com.leetcode.test272.contest.second;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public long minimumPossibleSum (int n, int target) {
    long ans = 0;
    int count = 0;
    int curr = 1;
    Set<Integer> set = new HashSet<>();
    while (count < n) {
      if(!set.contains(target - curr)) {
        ans += curr;
        set.add(curr);
        count++;
      }
      curr++;
    }
    return ans;
  }

  public static void main (String[] args) {

  }
}
