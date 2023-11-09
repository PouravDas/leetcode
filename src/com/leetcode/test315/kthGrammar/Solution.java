package com.leetcode.test315.kthGrammar;

//779. K-th Symbol in Grammar
//medium
class Solution {
  public int kthGrammar(int n, int k) {
    return helper(n - 1, k -1);
  }

  int helper(int n , int k) {
    if(n == 0 || k == 0) return 0;
    int prev = helper(n - 1, k / 2);
    if(prev == 0) {
      return (k & 1) == 0 ? 0 : 1;
    } else {
      return (k & 1) == 0 ? 1 : 0;
    }
  }
}
