package com.leetcode.test281.countOrders;

//1359. Count All Valid Pickup and Delivery Options
//hard
class Solution {
  int MOD = 1000_000_000 + 7;
  public int countOrders(int n) {
    long ans = 1;
    n *= 2;
    while(n > 2) {
      int pos = n - 1;
      long nSum = (pos * (pos + 1) / 2) % MOD;
      ans *= nSum;
      ans %= MOD;
      n -= 2;
    }
    return (int)ans;
  }
}
