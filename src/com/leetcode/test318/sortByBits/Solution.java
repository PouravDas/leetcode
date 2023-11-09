package com.leetcode.test318.sortByBits;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int[] sortByBits(int[] arr) {
    Comparator<Integer> comp = (a,b) -> {
      int a_ones = Integer.bitCount(a);
      int b_ones = Integer.bitCount(b);
      return a_ones == b_ones ? a - b : a_ones - b_ones;
    };
    PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
    for (int a : arr) {
      queue.offer(a);
    }
    int i =0;
    while(!queue.isEmpty()){
      arr[i++] = queue.poll();
    }
    return arr;
  }
}
