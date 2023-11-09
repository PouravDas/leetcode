package com.leetcode.test310.contest.test1;

import java.util.PriorityQueue;

class Solution {
  public int[] findIndices (int[] nums, int indexDifference, int valueDifference) {
    Element[] arr = new Element[nums.length];
    PriorityQueue<Element> queue = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      arr[i] = new Element(nums[i], i);
      queue.add(arr[i]);
      /*if (indexDifference == 0) {
        if (Math.abs(arr[i].val - queue.peek().val) >= valueDifference)
          return new int[] {queue.peek().idx, arr[i].idx};
      }*/
    }
    int l = 0;
    int r = 0;
    while (r < indexDifference) {
      queue.remove(arr[r++]);
    }
    while (r < nums.length) {
      Element toAdd = arr[l++];
      if (!queue.isEmpty() && Math.abs(toAdd.val - queue.peek().val) >= valueDifference)
        return new int[] {toAdd.idx, queue.peek().idx};
      queue.add(toAdd);
      queue.remove(arr[r++]);
    }
    return new int[] {-1, -1};
  }

  static class Element implements Comparable<Element> {
    int val;
    int idx;

    Element (int v, int i) {
      val = v;
      idx = i;
    }

    @Override public int compareTo (Element o) {
      return o.val - this.val;
    }

    @Override public String toString () {
      return "Element{" + "val=" + val + ", idx=" + idx + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findIndices(new int[]{8,0},1,7);
    s.findIndices(new int[]{5,1,4,1},2 ,4);
  }
}
