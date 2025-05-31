package com.leetcode.test117.binaryTreeRightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GfgV2 {

  //Function to return a list of nodes visible from the top view
  //from left to right in Binary Tree.
  static ArrayList<Integer> topView (Node root) {
    Map<Integer, Integer> treeMap = new TreeMap<>();
    if(root == null) return new ArrayList<>();

    Queue<Pair> queue = new ArrayDeque<>();

    queue.offer(new Pair(0, root));
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Pair pair = queue.poll();
        if(!treeMap.containsKey(pair.pos))
          treeMap.put(pair.pos, pair.node.data);
        if(pair.node.left != null)
          queue.offer(new Pair(pair.pos - 1, pair.node.left));
        if(pair.node.right != null)
          queue.offer(new Pair(pair.pos + 1, pair.node.right));
      }
    }
    return new ArrayList<>(treeMap.values());
  }

  static class Pair {
    int pos;
    Node node;

    Pair (int p, Node n) {
      pos = p;
      node = n;
    }
  }

  static class Node {
    int data;
    Node left;
    Node right;

    Node (int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
}
