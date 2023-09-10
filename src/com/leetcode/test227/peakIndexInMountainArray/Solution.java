package com.leetcode.test227.peakIndexInMountainArray;

//852. Peak Index in a Mountain Array
class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int start = 1;
    int end = arr.length - 2;
    while (start <= end) {
      int mid = end + start;
      mid /= 2;
      if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      }
      else if(arr[mid] > arr[mid -1]) {
        start = mid + 1;
      } else {
        end = mid -1;
      }
    }
    return -1;
  }
}
