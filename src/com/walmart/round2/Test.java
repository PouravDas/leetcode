package com.walmart.round2;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

//[ 2,3,4,5,2,3,1,3,3,1,9,5,3,4]
public class Test {

  //9,5,5,4,4,3,3,3,3

  public static void main (String[] args) {
    int[] arr = new int[] {2,3,4,5,2,3,1,3,3,1,9,5,3,4};
    int ans = findThirdHighest(new int[] {2,3,4,5,2,3,1,3,3,1,9,5,3,4},3);
    System.out.println(ans);

    mergeSort(arr);

    System.out.println("arr -> ");
    for (int a : arr)
      System.out.print(a);
  }

  public static int findThirdHighest(int[] arr, int count) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int a : arr) {
      if(queue.contains(a))
        continue;
      queue.add(a);
    }
    int highest = 0;
    if(queue.size() < count) {
      throw new RuntimeException("no result");
    }
    while (count-- > 0 ) {
      highest = queue.poll();
    }
    return highest;
  }


  public static void mergeSort(int[] arr) {

    // 3 5 1

    mergeSort(arr, 0, arr.length -1);
  }

  private static void mergeSort (int[] arr, int l, int r) {

    if( l < r) {
      int mid = (r + l) / 2; // 1
      mergeSort(arr, l, mid);
      mergeSort(arr, mid + 1, r);

      int[] mer = new int[r - l + 1];

      int lPoint = l;
      int rPoint = mid + 1;
      int merPoint = 0;

      while (lPoint <= mid && rPoint <= r) {
        if (arr[lPoint] < arr[rPoint]) {
          mer[merPoint++] = arr[lPoint++];
        } else {
          mer[merPoint++] = arr[rPoint++];
        }
      }

      while(lPoint <= mid) {
        mer[merPoint++] = arr[lPoint++];
      }

      while(rPoint <= r) {
        mer[merPoint++] = arr[rPoint++];
      }

      merPoint = 0;
      for (int i = l; i <= r; i++) {
        arr[i] = mer[merPoint++];
      }
    }
  }
}
