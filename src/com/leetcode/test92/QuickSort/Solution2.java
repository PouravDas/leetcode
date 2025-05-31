package com.leetcode.test92.QuickSort;

public class Solution2 {
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int p = partitionSort(arr, start, end);
      quickSort(arr, start, p - 1);
      quickSort(arr, p + 1, end);
    }
  }

  public int partitionSort(int[] arr, int start, int end) {
    int pivot = arr[start];
    int s = start;
    int e = end;
    while (s < e) {
      while (arr[s] <= pivot && s < e) s++;
      while (arr[e] > pivot && e >= s) e--;
      if (s < e)
        swap(arr, s, e);
    }
    swap(arr, start, e);
    return e;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    //int[] arr = new int[]{4, 10, 3, 6, 12, 2, 7};
    int[] arr = new int[]{110, 100, 0};

    printArray(arr);
    Solution2 s = new Solution2();
    s.sort(arr);
    printArray(arr);
  }

  static void printArray(int[] arr) {
    for(int a : arr) {
      System.out.print(a + ", ");
    }
    System.out.println();
  }
}
