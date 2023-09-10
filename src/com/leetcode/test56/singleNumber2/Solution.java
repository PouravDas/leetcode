package com.leetcode.test56.singleNumber2;

//question #137
public class Solution {
  public int singleNumber (int[] nums) {

    int[] bits = new int[32];
    int[] bitsNeg = new int[32];

    for (int n : nums) {
      int i = 0;
      if (n >= 0) {
        while (n != 0 && i != 32) {
          bits[i] += n & (1);
          n = n >> 1;
          i++;
        }
      } else {
        n = n * -1;
        while (n != 0 && i != 32) {
          bitsNeg[i] += n & (1);
          n = n >> 1;
          i++;
        }
      }
    }

    long ans = 0;
    boolean isPos = false;
    for (int i = 0; i < 32; i++) {
      if (bits[i] % 3 != 0) {
        isPos = true;
        ans += Math.pow(2, i);
      }
    }
    if (isPos)
      return (int) ans;

    ans = 0;
    for (int i = 0; i < 32; i++) {
      if (bitsNeg[i] % 3 != 0) {
        ans += Math.pow(2, i);
      }
    }

    return (int) (ans * -1);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.singleNumber(new int[] {2, 2, 3, 2});
  }
}
