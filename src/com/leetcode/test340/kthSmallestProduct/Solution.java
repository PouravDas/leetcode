package com.leetcode.test340.kthSmallestProduct;

public class Solution {
  public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    int start1 = 0;
    int start2 = 0;
    int end1 = nums1.length - 1;
    int end2 = nums2.length - 1;

    long l = 0;
    while (k != 0) {
      // case both start with neg
      if (nums1[start1] < 0 && nums2[start2] < 0) {
        int prod1 = nums1[start1] * nums2[end2];
        int prod2 = nums2[start2] * nums1[end1];
        if (prod1 < prod2) {
          l = prod1;
          end2--;
          if (end2 < 0 || nums2[end2] >= 0) {
            start1++;
            end2 = nums2.length - 1;
          }
        } else {
          l = prod2;
          end1--;
          if (end1 < 0 || nums1[end1] >= 0) {
            start2++;
            end1 = nums1.length - 1;
          }
        }
      }

      // case first neg second pos
      // case first positive second neg
      // case both are positive
      if (nums1[start1] > 0 && nums2[start2] > 0) {

      }

      k--;
    }
    return l;
  }
}
