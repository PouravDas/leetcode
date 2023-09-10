package com.leetcode.test60.countTripletsForXOR;

// question #1442
// Count Triplets That Can Form Two Arrays of Equal XOR
class Solution {
  public int countTriplets(int[] arr) {

    int ans = 0;

    for(int i = 0; i < arr.length;i++){
      int xor = arr[i];
      for(int j = i + 1; j < arr.length; j++){
        xor ^= arr[j];

        if(xor == 0){
          ans += j - i;
        }
      }
    }
    return ans;
  }
}
