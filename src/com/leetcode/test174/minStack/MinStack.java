package com.leetcode.test174.minStack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {

  ArrayDeque<Integer> stack;
  PriorityQueue<Integer> queue;

  public MinStack() {
    stack = new ArrayDeque<>();
    queue = new PriorityQueue<>();
  }

  public void push(int val) {
    stack.push(val);
    queue.offer(val);
  }

  public void pop() {
    queue.remove(stack.pop());
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return queue.peek();
  }
}
