package com.leetcode.test291.nasdaq.test;

class A {

  static boolean exists(int[] ints, int k) {
    int start = 0;
    int end = ints.length - 1;
    while(start <= end) {
      int mid = (end + start) / 2;
      if(ints[mid] == k) return true;
      else if(mid > k) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }

  public static void main (String[] args) {
    exists(new int[]{-9, 14, 37, 102}, 102);
  }
}
