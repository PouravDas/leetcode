package com.leetcode.test71.timeBaseKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  TimeMap map;

  public Solution(){
    map = new TimeMap();
  }

  public void set(String key, String value, int timestamp){
    map.set(key,value,timestamp);
  }

  public String get(String key, int timestamp) {
    return map.get(key,timestamp);
  }

  class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
      map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      Map<Integer, String> treeMap = map.compute(key, (k,v) -> v == null ? new TreeMap<>() : v);
      treeMap.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
      TreeMap<Integer, String> treeMap = map.get(key);
      if(treeMap == null){
        return "";
      } else {
        Integer floorKey = treeMap.floorKey(timestamp);
        if(floorKey == null)
          return "";
        String val = treeMap.get(floorKey);
        if(val == null){
          return "";
        } else {
          return val;
        }
      }
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.set("foo","bar",1);
    System.out.println(s.get("foo",1));
  }

  /**
   * Your TimeMap object will be instantiated and called as such:
   * TimeMap obj = new TimeMap();
   * obj.set(key,value,timestamp);
   * String param_2 = obj.get(key,timestamp);
   */
}
