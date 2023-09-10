package com.leetcode.test189.add2numbers;

import java.util.HashSet;

//371. Sum of Two Integers
public class Solution {
  public int getSum(int a, int b) {
    int result = 0;
    boolean carry = false;
    for (int i = 0; i < 32; i++) {
      boolean bitA = (a & (1 << i)) != 0;
      boolean bitB = (b & (1 << i)) != 0;
      boolean setR = false;
      if(bitA && bitB){
        if(carry){
          setR = true;
        } else {
          carry = true;
        }
      } else if (bitA || bitB) {
        if(carry){
          carry = false;
        } else {
          setR = true;
        }
      } else {
        if(carry){
          setR = true;
        }
      }
      if(setR){
        result = result | ((1 << i));
      }
    }
    return result;

  }
}
