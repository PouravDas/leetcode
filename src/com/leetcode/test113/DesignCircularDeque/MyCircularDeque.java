package com.leetcode.test113.DesignCircularDeque;

public class MyCircularDeque {

  private int[] arr;
  private int front;
  private int last;

  public MyCircularDeque (int k) {
    arr = new int[k];
    front = last = -1;
  }

  public boolean insertFront (int value) {
    if (isEmpty()) {
      front = last = 0;
      arr[front] = value;
      return true;
    } else if (isFull()) {
      return false;
    } else {
      front--;
      if(front == -1)
        front = arr.length -1;
      arr[front] = value;
      return true;
    }
  }

  public boolean insertLast (int value) {
    if (isEmpty()) {
      front = last = 0;
      arr[front] = value;
      return true;
    } else if (isFull()) {
      return false;
    } else {
      last = (last + 1) % arr.length;
      arr[last] = value;
      return true;
    }
  }

  public boolean deleteFront () {
    if(isEmpty())
      return false;
    else if (isSingle()){
      front = last = -1;
    } else {
      front = (front + 1) % arr.length;
    }
    return true;
  }

  public boolean deleteLast () {
    if(isEmpty())
      return false;
    else if (isSingle()){
      front = last = -1;
    } else {
      last--;
      if(last == -1)
        last = arr.length -1;
    }
    return true;
  }

  public int getFront () {
    if(isEmpty())
      return -1;
    return arr[front];
  }

  public int getRear () {
    if(isEmpty())
      return -1;
    return arr[last];
  }

  public boolean isEmpty () {
    return front == -1;
  }

  public boolean isFull () {
    return (last + 1) % arr.length == front;
  }

  private boolean isSingle () {
    return front == last;
  }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
