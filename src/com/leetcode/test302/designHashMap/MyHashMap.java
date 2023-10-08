package com.leetcode.test302.designHashMap;

//706. Design HashMap
class MyHashMap {

  int[] arr;
  int capacity;

  public MyHashMap () {
    capacity = 1000_001;
    arr = new int[capacity];
  }

  public void put (int key, int value) {
    arr[key] = value + 1;
  }

  public int get (int key) {
    return arr[key] == 0 ? -1 : arr[key] - 1;
  }

  public void remove (int key) {
    arr[key] = 0;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
