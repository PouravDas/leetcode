package com.leetcode.test272.contest.first;

class Solution {
  public int furthestDistanceFromOrigin(String moves) {
    int l = 0;
    int r = 0;
    int gap = 0;
    for (char m : moves.toCharArray()) {
      if(m == 'L') l++;
      else if (m == 'R') r++;
      else gap++;
    }
    return Math.max(l,r) - Math.min(l,r) + gap;
  }
}
