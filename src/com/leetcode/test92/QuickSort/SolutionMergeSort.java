package com.leetcode.test92.QuickSort;

public class SolutionMergeSort {

  public int[] sortArray (int[] nums) {

    mergeSort(0, nums.length - 1, nums);
    return nums;
  }

  private void mergeSort (int start, int end, int[] nums) {
    if (start >= end) {
      return;
    }
    int mid = start + end;
    mid /= 2;
    mergeSort(start, mid, nums);
    mergeSort(mid + 1, end, nums);
    merge(start, mid, end, nums);
  }

  private void merge (int start, int mid, int end, int[] nums) {
    int[] b = new int[end - start + 1];
    int i = start;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= end) {
      if (nums[i] < nums[j]) {
        b[k++] = nums[i++];
      } else {
        b[k++] = nums[j++];
      }
    }
    while (i <= mid) {
      b[k++] = nums[i++];
    }
    while (j <= end) {
      b[k++] = nums[j++];
    }
    k = 0;
    for (i = start; i <= end; i++) {
      nums[i] = b[k++];
    }
  }
}
