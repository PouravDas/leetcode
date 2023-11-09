package com.epam.test2;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean solution(int[] A, int[] B) {
    // Implement your solution here
    // just need to check nothing is repeating in each array
    // and no self link

    Set<Integer> aSet = new HashSet<>();
    Set<Integer> bSet = new HashSet<>();
    int[] link = new int[A.length];
    for(int i = 0; i < A.length; i++) {
      if(aSet.contains(A[i])) return false;
      if(bSet.contains(B[i])) return false;

      if(A[i] == B[i]) return false;

      aSet.add(A[i]);
      bSet.add(B[i]);

      link[A[i] -1] = B[i] - 1;
    }

    return dfs(link, 0, new HashSet<>());
  }

  boolean dfs (int[] link, int i, Set<Integer> visited) {
    if(visited.contains(i)) {
      if(visited.size() == link.length)
        return true;
      else
        return false;
    }
    else {
      visited.add(i);
      return dfs(link, link[i], visited);
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.solution(new int[]{3, 1, 2},new int[]{2, 3, 1});
  }
}
