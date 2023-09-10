package com.leetcode.test4.binaryMaxPathSum;

public class Solution_3 {

	public static void main(String[] args) {

		Solution_3 s = new Solution_3();
		TreeNode tn = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)),				new TreeNode(5, null, new TreeNode(5)));

		//TreeNode tn = new TreeNode(4, new TreeNode(4), new TreeNode(4));
		
		//TreeNode tn = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(5,new TreeNode(5), null));
		int ans = s.longestUnivaluePath(tn);
		System.out.println(ans);

	}

	int max = 1;

	public int longestUnivaluePath(TreeNode root) {

		longest(root);
		return max;
	}

	private int longest(TreeNode root) {

		int l = 0, r = 0;
		if (root.left != null && root.val == root.left.val)
			l = 1 + longest(root.left);
		else if (root.left != null)
			longest(root.left);

		if (root.right != null && root.val == root.right.val)
			r = 1 + longest(root.right);
		else if(root.right != null )
			longest(root.right);

		int localMax;
        if(l > 0 && r > 0)
            localMax = l + r;
        else
            localMax = Math.max(l, r);

		max = Math.max(max, localMax);

		return Math.max(l, r);
	}
}
