package com.walmart;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class Test {

  public static void main (String[] args) {
    sort(new int[]{2,0,2,1,1,0});
  }

  public static void sort(int[] arr) {

    //  [2,0,2,1,1,0]

    /**
     *
     * [2,0,2,1,1,0]
     *
     * l = 0;
     * r = 5
     * 0,0,2,1,1,2
     * l= 2
     * r = 4
     *
     */

    System.out.println("input :");
    for (int a: arr)
      System.out.print(a);
    int l = 0;
    int r = arr.length -1;

    while(l < r) {
      while(l < arr.length && arr[l] == 0) {
        l++;
      }
      while (r >= 0 && arr[r] != 0) {
        r--;
      }
      if( l >= r) {
        break;
      }
      swap(arr, l, r);
      l++;
      r--;
    }

    r = arr.length -1 ;

    while(l < r) {
      while(l < arr.length && arr[l] == 1){
        l++;
      }
      while (r >= 0 && arr[r] != 1) {
        r--;
      }
      if( l >= r) {
        break;
      }
      swap(arr, l, r);
      l++;
      r--;
    }

    System.out.println("ans :");
    for (int a: arr)
      System.out.print(a);
  }

  private static void swap (int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }
}

