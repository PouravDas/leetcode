package com.leetcode.test185.increasingTriplet;

//334. Increasing Triplet Subsequence
public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int left = Integer.MAX_VALUE;
    int mid = Integer.MAX_VALUE;
    for (int i : nums) {
      if(i <= left) {
        left = i;
      } else if (i <= mid) {
        mid = i;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main (String[] args) {
    double f = 1.0 / 0.0;
    System.out.println(f);
  }
}
