package com.leetcode.test319.getWinner;

import java.util.LinkedList;
import java.util.List;

//1535. Find the Winner of an Array Game
class Solution {
  public int getWinner(int[] arr, int k) {
    List<Integer> list = new LinkedList<>();
    for (int a :arr) list.add(a);
    int count = 0;
    int totalCount = 0;
    while (true) {
      if(list.get(0) > list.get(1)) {
        count++;
        int small = list.get(1);
        list.remove(1);
        list.add(small);
      } else {
        count = 1;
        int small = list.get(0);
        list.remove(0);
        list.add(small);
      }
     if(count == k) return list.get(0);
     totalCount++;
     if(totalCount > arr.length) return list.get(0);
    }
  }
}
