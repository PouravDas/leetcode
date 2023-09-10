package com.leetcode.test10.treewidth;

import java.util.HashMap;

import com.leetcode.test4.binaryMaxPathSum.TreeNode;

public class Solution {

	public static void main(String[] args) {

	}

	HashMap<Integer, Integer> levelStart = new HashMap<>();
	int ans = 0;
	

	public int widthOfBinaryTree(TreeNode root) {
System.out.println();
		findWidth(root, 0, 1);
		System.out.println(levelStart);
		return ans;
	}

	private void findWidth(TreeNode root, int l, int w) {
		if (levelStart.get(l) == null)
			levelStart.put(l, w);

		ans = Math.max(ans, w - levelStart.get(l) + 1);

		if (root == null)
			return;
		else {
			if (root.left != null)
				findWidth(root.left, l + 1, w + w -1);
			if (root.right != null)
				findWidth(root.right, l + 1, w + w);
		}

	}

}
