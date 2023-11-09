package com.sap.test;

public class Test {

  /**
   * @param args [2:05 PM] Unny, Ajay
   *             <p>
   *             Reverse string with special characters
   *             <p>
   *             Input = ab!cd*e
   *             <p>
   *             ab!cd*e
   *             <p>
   *             ba!dc
   *             e*dc!ba
   *             <p>
   *             Output= ed!cb*a
   */
  public static void main (String[] args) {
    String input = "ab!cd*e";
  }

  String reverseWithSpe (String input) {
    char[] arr = input.toCharArray();
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {

      if(isSpecial(arr[left])) {
        left++;
        continue;
      }

      if(isSpecial(arr[right])) {
        right--;
        continue;
      }

      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    return new String(arr);
  }

  boolean isSpecial (char c) {
    return false;
  }
}
