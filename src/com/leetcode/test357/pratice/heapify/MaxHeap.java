package com.leetcode.test357.pratice.heapify;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * O(n) not O(nlogn)
 */
public class MaxHeap {

  public void heapify(int[] arr, int n, int i) {
    int large = i;
    int l = i * 2 + 1;
    int r = i * 2 + 2;

    if (l < n && arr[l] > arr[large]) {
      large = l;
    }
    if (r < n && arr[r] > arr[large]) {
      large = r;
    }

    if (large != i) {
      swap(arr, i, large);
      heapify(arr, n, large);
    }
  }

  public void insert(int[] arr, int n, int val) {
    arr[n] = val;
    int c = n;
    while (c > 0) {
      int p = (c - 1) / 2;
      if (arr[p] >= arr[c]) {
        return;
      } else {
        swap(arr, p, c);
        c = p;
      }
    }
  }

  public int pop(int[] arr, int n) {
    int ans = arr[0];
    int last = arr[n - 1];
    n--;
    arr[0] = last;
    int p = 0;
    while (p < n) {
      int l = p * 2 + 1;
      int r = p * 2 + 2;
      int large = p;

      if (l < n && arr[l] > arr[large]) {
        large = l;
      }
      if (r < n && arr[r] > arr[large]) {
        large = r;
      }
      if (large != p) {
        swap(arr, p, large);
        p = large;
      } else {
        break;
      }
    }
    return ans;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : nums) {
      pq.add(n);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }

  class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
      min = new PriorityQueue<>();
      max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
      if (max.isEmpty() || num < max.peek()) {
        max.add(num);
      } else {
        min.add(num);
      }
      if (max.size() - min.size() > 1) {
        min.add(max.poll());
      } else if (min.size() > max.size()) {
        max.add(min.poll());
      }
    }

    public double findMedian() {
      if (max.size() == min.size()) {
        return ((double) max.peek() + (double) min.peek()) / 2;
      } else {
        return max.peek();
      }
    }
  }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
