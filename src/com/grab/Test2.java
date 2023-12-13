package com.grab;

/**
 * [1,2,3,4], 2
 * <p>
 * 4,1,2,3   1      len - 1 (4 - 1 = 3)
 * 3,4,1,2   2      len - 2
 * 2,3,4,1   3
 * 1,2,3,4   4
 * 4,1,2,3   5
 * Rotate the array to the right according to the number given and return the rotated string
 */
public class Test2 {
  public static int[] solution (int[] arr, int rotate) {
    rotate = rotate % arr.length;
    if (rotate == 0)
      return arr;
    int[] ans = new int[arr.length];
    int idx = 0;
    for (int i = arr.length - rotate; i < arr.length; i++) {
      ans[idx++] = arr[i];
    }
    for (int i = 0; i < arr.length - rotate; i++) {
      ans[idx++] = arr[i];
    }
    return ans;
  }

  public static void main (String[] args) {
    int[] ans = Test2.solution(new int[] {1, 2, 3, 4}, 2);
    System.out.println();
    System.out.print("[");
    for (int i : ans) System.out.print("," + i);
    System.out.print("]");
  }

  /**
   *
   *
   * 5,6,7,8,1,2,3,4
   * 0,1,2,3,4,5,6,7
   *
   * l = 5 r= 4
   *
   * m= 8
   *
   * l = l + 1 = 6
   * r = 4
   *
   * m = (6 + 4) / 2 = 5
   *
   */
}
