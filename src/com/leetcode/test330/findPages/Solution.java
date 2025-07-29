package com.leetcode.test330.findPages;

import java.util.Arrays;

//Allocate Minimum Pages
public class Solution {
  public static int findPages(int[] arr, int k) {
    // code here
    if(k > arr.length) return -1;
    int min = Arrays.stream(arr).max().getAsInt();
    int max = Arrays.stream(arr).sum();
    int result = -1;
    while (min <= max) {
      int mid = (max + min) / 2;
      if (isPossible(arr, k, mid)) {
        result = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return result;
  }

  static boolean isPossible(int[] arr, int k, int target) {
    int sum = 0;
    int students = 1;
    for (int a : arr) {
      if (sum + a > target) {
        students++;
        sum = a;
      } else {
        sum += a;
      }
    }
    return students <= k;
  }

  public static void main(String[] args) {
    Solution.findPages(new int[]{12, 34, 67, 90}, 2);
  }
}
