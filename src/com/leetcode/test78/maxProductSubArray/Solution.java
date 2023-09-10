package com.leetcode.test78.maxProductSubArray;

class Solution {
  public int maxProduct_ (int[] nums) {

    int maxProd = Integer.MIN_VALUE;
    int currProd = Integer.MIN_VALUE;
    int firstNegProd = Integer.MIN_VALUE;
    int lastPosProd = Integer.MIN_VALUE;
    boolean firstNegFound = false;

    int idx = 0;
    while (idx < nums.length) {
      int n = nums[idx];
      maxProd = Math.max(maxProd, n);
      if (n == 0) {
        if (currProd < 0 && firstNegFound && currProd != firstNegProd) {
          maxProd = Math.max(maxProd, Math.max(lastPosProd, (currProd / firstNegProd)));
        }
        currProd = Integer.MIN_VALUE;
        firstNegProd = Integer.MIN_VALUE;
        lastPosProd = Integer.MIN_VALUE;
        firstNegFound = false;
      } else {
        if (currProd > 0) {
          lastPosProd = currProd;
        }
        if (currProd == Integer.MIN_VALUE) {
          currProd = 1;
        }
        currProd *= n;
        maxProd = Math.max(maxProd, currProd);
        if (!firstNegFound) {
          firstNegProd = currProd;
        }
        if( n < 0){
          firstNegFound = true;
        }
      }
      idx++;
    }
    return maxProd;
  }

  public int maxProduct (int[] nums) {
    int maxProd = Integer.MIN_VALUE;
    int prod = 1;
    for (int i : nums) {
      if (i == 0) {
        maxProd = Math.max(maxProd, i);
        prod = 1;
        continue;
      }
      prod *= i;
      maxProd = Math.max(maxProd, prod);
    }

    prod = 1;

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 0) {
        maxProd = Math.max(maxProd, nums[i]);
        prod = 1;
        continue;
      }
      prod *= nums[i];
      maxProd = Math.max(maxProd, prod);
    }

    return maxProd;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.maxProduct(new int[] {-2});
    System.out.println(ans);
  }
}
