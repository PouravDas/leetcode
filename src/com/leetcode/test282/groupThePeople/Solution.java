package com.leetcode.test282.groupThePeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1282. Group the People Given the Group Size They Belong To
class Solution {
  public List<List<Integer>> groupThePeople (int[] groupSizes) {
    List<List<Integer>> mainList = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      if (map.get(groupSizes[i]) == null) {
        map.put(groupSizes[i], new ArrayList<>());
      }
      map.get(groupSizes[i]).add(i);
      if (map.get(groupSizes[i]).size() == groupSizes[i]) {
        mainList.add(map.remove(groupSizes[i]));
      }
    }
    return mainList;
  }
}
