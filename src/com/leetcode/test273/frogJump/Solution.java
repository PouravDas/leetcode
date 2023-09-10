package com.leetcode.test273.frogJump;

//403. Frog Jump
//hard
class Solution {
  public boolean canCross (int[] stones) {
    if(stones[1] != 1) return false;
    Boolean[][] dp = new Boolean[stones.length][2000];
    return canCross(stones, 1, 1, dp);
  }

  boolean canCross (int[] stones, int idx, int jump, Boolean[][] dp) {
    if (idx == stones.length - 1)
      return true;
    if (dp[idx][jump] != null)
      return dp[idx][jump];
    boolean ans = false;
    int i = idx + 1;
    //k-1
    if (jump > 1) {
      while (i < stones.length && stones[i] - stones[idx] < jump - 1) {
        i++;
      }
      if (i < stones.length && stones[i] - stones[idx] == jump - 1) {
        ans = canCross(stones, i, jump - 1, dp);
      }
    }
    //k
    if (!ans) {
      while (i < stones.length && stones[i] - stones[idx] < jump) {
        i++;
      }
      if (i < stones.length && stones[i] - stones[idx] == jump) {
        ans = canCross(stones, i, jump, dp);
      }
    }
    //k+1
    if (!ans) {
      while (i < stones.length && stones[i] - stones[idx] < jump + 1) {
        i++;
      }
      if (i < stones.length && stones[i] - stones[idx] == jump + 1) {
        ans = canCross(stones, i, jump + 1, dp);
      }
    }
    return dp[idx][jump] = ans;
  }
}
