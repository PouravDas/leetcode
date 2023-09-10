package com.leetcode.test274.myStack;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

  Queue<Integer> queue;

  public MyStack () {
    queue = new ArrayDeque<>();
  }

  public void push (int x) {
    queue.offer(x);
  }

  public int pop () {
    if(queue.size() == 1) return queue.poll();
    int size = queue.size();
    for (int i = 0; i < size - 1; i++) {
      queue.offer(queue.poll());
    }
    return queue.poll();
  }

  public int top () {
    if(queue.size() == 1) return queue.peek();
    int size = queue.size();
    for (int i = 0; i < size - 1; i++) {
      queue.offer(queue.poll());
    }
    int ans = queue.peek();
    queue.offer(queue.poll());
    return ans;
  }

  public boolean empty () {
    return queue.isEmpty();
  }

  public static void main (String[] args) {
    MyStack obj = new MyStack();
    obj.push(1);
    obj.push(2);
    int param_2 = obj.pop();
    int param_3 = obj.top();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
