package com.leetcode.test200.minimumTotalTriangle;

import java.util.List;

class Solution {
  public int minimumTotal (List<List<Integer>> triangle) {
    for (int i = triangle.size() - 1; i > 0; i--) {
      List<Integer> downList = triangle.get(i);
      List<Integer> upList = triangle.get(i - 1);
      for (int j = 0; j < upList.size(); j++) {
        upList.set(j, Math.min(downList.get(j), downList.get(j + 1)) + upList.get(j));
      }
    }
    return triangle.get(0).get(0);
  }
}
