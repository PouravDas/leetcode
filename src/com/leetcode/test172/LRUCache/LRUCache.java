package com.leetcode.test172.LRUCache;

import java.util.HashMap;
import java.util.Map;

//146. LRU Cache
class LRUCache {

  int capacity;
  Map<Integer, Node> map;
  Node head, tail;

  public LRUCache (int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  public int get (int key) {
    if (map.containsKey(key)) {
      remove(map.get(key));
      insert(map.get(key));
      return map.get(key).value;
    }
    return -1;
  }

  public void put (int key, int value) {
    if (map.containsKey(key)) {
      get(key);
      map.get(key).value = value;
    } else {
      if (map.size() == capacity) {
        removeLRU();
      }
      Node n = new Node(key, value);
      insert(n);
      map.put(key, n);
    }
  }

  private void removeLRU () {
    map.remove(head.key);
    remove(head);
  }

  private void remove (Node node) {
    Node p = node.prev;
    Node n = node.next;
    if (node == head) {
      head = n;
    } else if (node == tail) {
      tail = p;
    }
    if (p != null) {
      p.next = n;
    }
    if (n != null) {
      n.prev = p;
    }
  }

  private void insert (Node n) {
    if (head == null) {
      head = n;
      tail = n;
    } else {
      tail.next = n;
      n.prev = tail;
      tail = n;
    }
  }

  private static class Node {
    int key, value;
    Node prev, next;

    Node (int k, int v) {
      key = k;
      value = v;
    }
  }

  public static void main (String[] args) {

    LRUCache cache = new LRUCache(2);
    int[][] arr = new int[][] {{2, 1}, {3, 2}, {3}, {2}, {4, 3}, {2}, {3}, {4}};

    for (int[] a : arr) {
      if (a.length == 1)
        System.out.println(cache.get(a[0]));
      else
        cache.put(a[0], a[1]);
    }
  }
}
