package com.leetcode.test165.groupAnagrams;

import java.util.*;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> map = new HashMap<>();
    for(String s : strs){
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String sorted = new String(arr);
      if(!map.containsKey(sorted)){
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(s);
    }
    return new ArrayList<>(map.values());
  }
}
