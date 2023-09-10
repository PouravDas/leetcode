package com.leetcode.test186.serializeDeserializeBTree;

import java.util.ArrayDeque;
import java.util.Queue;

//297. Serialize and Deserialize Binary Tree
public class Codec {
  TreeNode NULL = new TreeNode(Integer.MIN_VALUE);
  // Encodes a tree to a single string.
  public String serialize (TreeNode root) {
    StringBuilder sb = new StringBuilder(10);
    stringify(root, sb);
    sb.delete(sb.length() - 1, sb.length());
    return sb.toString();
  }

  private void stringify (TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('N').append(',');
      return;
    }
    sb.append(root.val).append(',');
    stringify(root.left, sb);
    stringify(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize (String data) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode curr = null;
    boolean left = true;
    for (String d : data.split(",")) {
      if(d.equals("N")) {
        queue.offer(NULL);
      } else {
        queue.offer(new TreeNode(Integer.parseInt(d)));
      }
    }
    TreeNode root = queue.poll();
    if(root == NULL) return null;
    getRootNode(root, queue);
    return root;
  }

  private void getRootNode (TreeNode parent, Queue<TreeNode> queue) {
    if(parent == null) {
      return;
    } else {
      TreeNode node = queue.poll();
      parent.left = node == NULL ? null : node;
      getRootNode(parent.left, queue);
      node = queue.poll();
      parent.right = node == NULL ? null : node;
      getRootNode(parent.right, queue);
    }
  }

  private TreeNode getNext (Queue<TreeNode> queue, TreeNode NULL) {
    queue.poll();
    TreeNode next = null;
    while (queue.peek() != NULL) {
      next = queue.poll();
    }
    return next;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
      val = x;
    }
  }

  public static void main (String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;

    Codec codec = new Codec();
    String st = codec.serialize(null);
    TreeNode ans = codec.deserialize(st);
    System.out.println(ans);
  }
}
