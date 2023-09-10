package com.leetcode.test149.wineBuySell;

public class Solution {
  static long wineSelling (int arr[], int n) {
    // code here
    long ans = 0;
    int b = 0;
    int s = 0;

    while (b < n && s < n) {
      while (arr[b] <= 0) {
        b++;
        if (b == n)
          return ans;
      }
      while (arr[s] >= 0) {
        s++;
        if (s == n)
          return ans;
      }
      ans += Math.abs(b - s) * Math.min(arr[s] * -1, arr[b]);
      int tempS = arr[s];
      arr[s] = arr[s] * -1 > arr[b] ? arr[s] + arr[b] : 0;
      arr[b] = arr[b] > tempS * -1 ? arr[b] + tempS : 0;
    }
    return ans;
  }

  public static void main (String[] args) {
    wineSelling(new int[] {5, -4, 1, -3, 1}, 5);
  }
}
