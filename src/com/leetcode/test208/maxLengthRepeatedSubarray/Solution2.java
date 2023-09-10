package com.leetcode.test208.maxLengthRepeatedSubarray;

public class Solution2 {
  public int findLength (int[] nums1, int[] nums2) {
    int[] small, big;
    if(nums1.length < nums2.length){
      small = nums1;
      big = nums2;
    } else {
      small = nums2;
      big = nums1;
    }
    int[] prevDp = new int[small.length];
    int[] currDp = new int[small.length];
    int max = 0;
    for (int row = 0; row < small.length; row++) {
      for (int col = 0; col < big.length; col++) {
        if (small[row] == big[col]) {
          currDp[row] = row > 0 ? prevDp[row - 1] + 1 : 1;
          max = Math.max(max, currDp[row]);
        }
      }
      int[] temp = prevDp;
      prevDp = currDp;
      currDp = temp;
    }
    return max;
  }
}
