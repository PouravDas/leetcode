package com.leetcode.test172.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

  int capacity;
  LinkedHashMap<Integer, Integer> map;

  public LRU (int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<>();
  }

  public int get (int key) {
    if (map.containsKey(key)) {
      int val = map.get(key);
      map.remove(key);
      map.put(key,val);
      return val;
    }
    return -1;
  }

  public void put (int key, int value) {
    if (map.containsKey(key)) {
      map.remove(key);
    } else {
      if (map.size() == capacity) {
        removeLRU();
      }
    }
    map.put(key,value);
  }

  private void removeLRU () {
    int key = -1;
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      key = e.getKey();
      break;
    }
    map.remove(key);
  }
}
