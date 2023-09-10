package com.leetcode.test126.verticalOrderTraversalBinaryTree;

import java.util.*;

//#987. Vertical Order Traversal of a Binary Tree
class Solution {
  int min = 0;
  int max = 0;

  public List<List<Integer>> verticalTraversal (TreeNode root) {
    Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
    verticalTraversal(root, 0, 0, map);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      List<Integer> l = new ArrayList<>();
      for (List<Integer> v : map.get(i).values()) {
        Collections.sort(v);
        l.addAll(v);
      }
      list.add(l);
    }
    return list;
  }

  private void verticalTraversal (TreeNode root, int ver, int height,
      Map<Integer, Map<Integer, List<Integer>>> map) {
    if (root == null)
      return;
    min = Math.min(min, ver);
    max = Math.max(max, ver);
    map.compute(ver, (k, v) -> {
      if (null == v) {
        Map<Integer, List<Integer>> innerMap = new TreeMap<>();
        innerMap.put(height, new ArrayList<>(List.of(root.val)));
        return innerMap;
      } else if (v.containsKey(height)) {
        v.get(height).add(root.val);
        return v;
      } else {
        v.put(height, new ArrayList<>(List.of(root.val)));
        return v;
      }
    });
    verticalTraversal(root.left, ver - 1, height + 1, map);
    verticalTraversal(root.right, ver + 1, height + 1, map);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
}
