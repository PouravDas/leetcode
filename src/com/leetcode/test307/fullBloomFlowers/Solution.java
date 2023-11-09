package com.leetcode.test307.fullBloomFlowers;

import java.util.Arrays;

//2251. Number of Flowers in Full Bloom
//hard
class Solution {
  public int[] fullBloomFlowers (int[][] flowers, int[] people) {
    int[] start = new int[flowers.length];
    int[] end = new int[flowers.length];
    for (int i = 0; i < flowers.length; i++) {
      start[i] = flowers[i][0];
      end[i] = flowers[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int[] ans = new int[people.length];
    for (int i = 0; i < people.length; i++) {
      ans[i] = binarySearchStart(people[i], start) - binarySearchEnd(people[i], end);
    }
    return ans;
  }

  //return the index of the element just greater then target
  int binarySearchStart (int target, int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (arr[mid] > target && mid != 0 && arr[mid - 1] <= target)
        return mid;
      if (arr[mid] <= target) {
        if (l != mid)
          l = mid;
        else
          l++;
      } else {
        if (r != mid)
          r = mid;
        else
          r--;
      }
    }
    return arr[l] <= target ? l + 1 : l;
  }

  int binarySearchEnd (int target, int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (arr[mid] >= target && mid != 0 && arr[mid - 1] < target)
        return mid;
      if (arr[mid] < target) {
        if (l != mid)
          l = mid;
        else
          l++;
      } else {
        if (r != mid)
          r = mid;
        else
          r--;
      }
    }
    return arr[l] < target ? l + 1 : l;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.fullBloomFlowers(new int[][] {{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[] {2, 3, 7, 11});
  }
}
