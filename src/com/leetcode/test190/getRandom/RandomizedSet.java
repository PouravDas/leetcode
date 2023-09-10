package com.leetcode.test190.getRandom;

import java.util.HashMap;
import java.util.Map;

//380. Insert Delete GetRandom O(1)
class RandomizedSet {
  Map<Integer, Integer> map;
  int[] arr = new int[1_00_00_00];
  int size = 0;

  public RandomizedSet () {
    map = new HashMap<>();
  }

  public boolean insert (int val) {
    boolean contains = map.containsKey(val);
    if (!contains) {
      arr[size++] = val;
      map.put(val, size - 1);
      return true;
    }
    return false;
  }

  public boolean remove (int val) {
    boolean contains = map.containsKey(val);
    if (contains) {
      int idx = map.remove(val);
      if (idx == size - 1) {
        --size;
      } else {
        arr[idx] = arr[--size];
        map.put(arr[idx], idx);
      }
      return true;
    }
    return false;
  }

  public int getRandom () {
    return arr[getRandIdx()];
  }

  private int getRandIdx () {
    return (int) (Math.random() * (size));
  }
}

