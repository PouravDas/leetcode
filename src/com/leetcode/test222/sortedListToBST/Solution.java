package com.leetcode.test222.sortedListToBST;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public TreeNode sortedListToBST (ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    return findMid(0,list.size()-1,list);
  }

  private TreeNode findMid(int start, int end, List<Integer> list) {
    if(start == end) {
      return new TreeNode(list.get(start));
    }
    if(start > end) return null;
    int mid = start + end;
    mid /= 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = findMid(start, mid -1, list);
    root.right = findMid(mid + 1, end,list);
    return root;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode (int val) {
      this.val = val;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


  public class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
      this.val = val;
    }

    ListNode (int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
