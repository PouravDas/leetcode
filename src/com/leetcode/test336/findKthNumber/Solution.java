package com.leetcode.test336.findKthNumber;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//440. K-th Smallest in Lexicographical Order
public class Solution {
  public int findKthNumber(int n, int k) {
    TreeSet<String> set = new TreeSet<>();
    for (int i = 1; i <= n ; i++) {
      set.add("" + i);
    }
    String ans = null;
    for (int i = 0; i < k; i++) {
      ans = set.pollFirst();
    }
    return Integer.parseInt(ans);
  }


}