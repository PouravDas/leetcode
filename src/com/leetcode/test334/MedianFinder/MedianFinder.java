package com.leetcode.test334.MedianFinder;

import java.util.Collections;
import java.util.PriorityQueue;

//#295. Find Median from Data Stream
public class MedianFinder {

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() > num) maxHeap.offer(num);
    else minHeap.offer(num);

    if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
    else if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());

  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
    return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
  }
}
