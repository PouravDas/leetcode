package com.leetcode.test11.validBST;

import com.leetcode.test4.binaryMaxPathSum.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    boolean isBST = true;
    
    public static void main(String[] args) {
    	TreeNode tn = new TreeNode(2, new TreeNode(2), new TreeNode(2));
    	
    	Solution s = new Solution();
    	s.isValidBST(tn);
    	System.out.println(s.isBST);
	}
    
    public boolean isValidBST(TreeNode root) {
        
        isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isBST;
    }
    
    private void isBST(TreeNode root, long lastLeft, long lastRight) {
        if(root == null)
            return;
        
        System.out.println("root.val = " + root.val + " lastLeft = " + lastLeft + " lastRight = " + lastRight);
        
        if(root.val >= lastLeft && root.val <= lastRight){
            isBST(root.left, lastLeft, root.val);
            isBST(root.right, root.val, lastRight);
        } else {
            System.out.println("Set now");
            isBST = false;
        }
    }
}
