package com.leetcode.test67.uniqePathsInNxMGrid;

class Solution {
  public int uniquePaths (int m, int n) {

    int big, small;

    if (m > n) {
      big = m - 1;
      small = n - 1;
    } else {
      big = n - 1;
      small = m - 1;
    }

    long ans = 1;
    int j = 1;
    for (int i = big + 1; i <= big + small; i++) {
      ans *= i;
      ans /= j++;
    }

    return (int) ans;
    //TLE but works
    //return uniquePaths(1, 1, m, n);
  }

  private int uniquePaths (int x, int y, int m, int n) {
    if (x == m || y == n) {
      return 1;
    } else {
      return uniquePaths(x + 1, y, m, n) + uniquePaths(x, y + 1, m, n);
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.uniquePaths(51, 9);
    System.out.println(ans);
  }
}
