package com.leetcode.test92.QuickSort;

//# 912
public class Solution {
  public int[] sortArray(int[] nums) {

    quickSort(0, nums.length - 1, nums);
    return nums;
  }

  private void quickSort(int start, int end, int[] nums) {
    if (start >= end) {
      return;
    }
    int pivot = nums[start];
    int i = start;
    int j = end;
    while (i < j) {
      while (i <= j && nums[i] <= pivot)
        i++;
      while (j >= 0 && nums[j] > pivot)
        j--;
      if (i < j) {
        swap(i, j, nums);
      }
    }
    swap(start, j, nums);

    quickSort(start, j - 1, nums);
    quickSort(j + 1, end, nums);
  }

  private void swap(int i, int j, int[] nums) {
    int tem = nums[i];
    nums[i] = nums[j];
    nums[j] = tem;
  }
  static void printArray(int[] arr) {
    for(int a : arr) {
      System.out.print(a + ", ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //SolutionMergeSort s = new SolutionMergeSort();
    int[] ans = s.sortArray(new int[]{4, 1, 9, 5, 2, 8, 3, 7, 6});
    ans = s.sortArray(test);
    printArray(test);
  }

  private static int[] test =
      new int[]{5, 1, 1, 2, 0, 0};
}
