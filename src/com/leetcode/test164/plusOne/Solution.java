package com.leetcode.test164.plusOne;

//66. Plus One
class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >=0 ; i--) {
      digits[i] += carry;
      if(digits[i] > 9){
        digits[i] %= 10;
      } else {
        carry = 0;
        break;
      }
    }
    if(carry == 0){
      return digits;
    } else {
      int[] ans = new int[digits.length + 1];
      ans[0]=1;
      int i = 1;
      for (int j = 0; j < digits.length; j++) {
        ans[i++] = digits[j];
      }
      return ans;
    }
  }
}
