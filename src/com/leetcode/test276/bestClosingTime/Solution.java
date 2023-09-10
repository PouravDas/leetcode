package com.leetcode.test276.bestClosingTime;

//2483. Minimum Penalty for a Shop
class Solution {
  public int bestClosingTime (String customers) {
    int[] openPenalty = new int[customers.length() + 1];
    int[] closePenalty = new int[customers.length() + 1];
    int[] totalPenalty = new int[customers.length() + 1];

    for (int i = 0; i < openPenalty.length; i++) {
      if(i == openPenalty.length -1) openPenalty[i] = openPenalty[i - 1];
      else if (customers.charAt(i) == 'N')
        openPenalty[i] = i == 0 ? 1 : 1 + openPenalty[i - 1];
      else
        openPenalty[i] = i == 0 ? 0 : openPenalty[i - 1];
    }

    closePenalty[closePenalty.length - 1] = 0;
    for (int i = closePenalty.length - 2; i > -1; i--) {
      if (customers.charAt(i) == 'Y')
        closePenalty[i] = i == closePenalty.length - 1 ? 1 : 1 + closePenalty[i + 1];
      else
        closePenalty[i] = i == closePenalty.length - 1 ? 0 : closePenalty[i + 1];
    }

    totalPenalty[0] = closePenalty[0];
    for (int i = 1; i < totalPenalty.length; i++) {
      totalPenalty[i] = closePenalty[i] + openPenalty[i - 1];
    }
    int idx = 0;
    for (int i = 0; i < totalPenalty.length; i++) {
      if (totalPenalty[i] < totalPenalty[idx]) {
        idx = i;
      }
    }
    return idx;
  }
}
