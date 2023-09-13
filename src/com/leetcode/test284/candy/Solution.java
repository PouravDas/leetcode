package com.leetcode.test284.candy;

//135. Candy (hard)
class Solution {
  public int candy (int[] ratings) {
    int[] candies = new int[ratings.length];
    for (int i = 0; i < ratings.length; i++) {
      int left = i == 0 ? Integer.MAX_VALUE : ratings[i - 1];
      if (left < ratings[i]) {
        candies[i] = candies[i - 1] + 1;
      } else {
        candies[i] = 1;
      }
    }
    for (int i = ratings.length - 1; i > -1; i--) {
      int right = i == ratings.length - 1 ? Integer.MAX_VALUE : ratings[i + 1];
      if (right < ratings[i]) {
        if (candies[i] <= candies[i + 1])
          candies[i] = candies[i + 1] + 1;
      }
    }
    int ans = 0;
    for (int c : candies)
      ans += c;
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.candy(new int[] {1, 0, 2});
    System.out.println(ans);
  }
}
