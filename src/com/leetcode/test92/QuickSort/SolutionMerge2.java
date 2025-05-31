package com.leetcode.test92.QuickSort;

public class SolutionMerge2 {
  public void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  }

  private void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = start + end;
      mid /= 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, end);
    }
  }

  private void merge(int[] arr, int start, int end) {
    int[] tem = new int[end - start + 1];
    int mid = start + end;
    mid /= 2;
    int i = start, j = mid + 1, k = 0;
    while (i <= mid && j <= end) {
      if (arr[i] <= arr[j]) tem[k++] = arr[i++];
      else tem[k++] = arr[j++];
    }
    while (i <= mid) tem[k++] = arr[i++];
    while (j <= end) tem[k++] = arr[j++];

    i = start;
    k = 0;
    while (i <= end) arr[i++] = tem[k++];
  }

  public static void main(String[] args) {
    SolutionMerge2 s = new SolutionMerge2();
    int[] arr = new int[]{4, 10, 3, 6, 12, 2, 7};

    printArray(arr);
    s.mergeSort(arr);
    printArray(arr);
  }

  static void printArray(int[] arr) {
    for(int a : arr) {
      System.out.print(a + ", ");
    }
    System.out.println();
  }
}
