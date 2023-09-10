package com.leetcode.test117.binaryTreeRightSideView;


import java.util.*;

// Top view of a binary tree
class GFG {
  //Function to return a list of nodes visible from the top view
  //from left to right in Binary Tree.
  static ArrayList<Integer> topView (Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Pair> queue = new ArrayDeque<>();
    int min = 0, max = 0;
    queue.add(new Pair(0, root));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      if (!map.containsKey(pair.pos)) {
        map.put(pair.pos, pair.node.data);
        min = Math.min(min, pair.pos);
        max = Math.max(max, pair.pos);
      }
      if (pair.node.left != null)
        queue.offer(new Pair(pair.pos - 1, pair.node.left));
      if (pair.node.right != null)
        queue.offer(new Pair(pair.pos + 1, pair.node.right));
    }
    for (int i = min; i <= max; i++)
      if (map.containsKey(i))
        list.add(map.get(i));
    return list;
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


  static class Pair {
    int pos;
    Node node;

    Pair (int p, Node n) {
      pos = p;
      node = n;
    }
  }

  public static void main (String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    node1.right = node2;
    ArrayList<Integer> list = GFG.topView(node1);
    System.out.println(list);
  }
}
