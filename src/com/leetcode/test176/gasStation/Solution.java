package com.leetcode.test176.gasStation;

//134. Gas Station
class Solution {
  public int canCompleteCircuit (int[] gas, int[] cost) {
    int totalGas = 0;
    int totalCost = 0;
    int startPoint = 0;
    int curGas = 0;
    for (int i = 0; i < cost.length; i++) {
      totalCost += cost[i];
      totalGas += gas[i];
      curGas += gas[i] - cost[i];
      if (curGas < 0) {
        startPoint = (i + 1) % cost.length;
        curGas = 0;
      }
    }
    if (totalCost > totalGas)
      return -1;
    else
      return startPoint;
  }
}
