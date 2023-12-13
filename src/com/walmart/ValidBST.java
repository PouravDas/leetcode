package com.walmart;


/**
 * 1,2,3,4
 * <p>
 * 3
 * 2   4
 *
 * 1
 *
 *        4
 *      2   5
 *     1 3
 */
public class ValidBST {

  public static void main (String[] args) {
    Tree validTree = new Tree(4, new Tree(2, new Tree(1), new Tree(3)), new Tree(5));
    System.out.println(isValidBST(validTree));

    Tree invalid =  new Tree(4, new Tree(2, new Tree(1), new Tree(5)), new Tree(5));
    System.out.println(isValidBST(invalid));
  }

  public static boolean isValidBST (Tree root) {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isValidBST (Tree root, int min, int max) {
    if (root == null)
      return true;
    if (root.val < min || root.val > max ) return false;
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }

  static class Tree {
    int val;
    Tree left;
    Tree right;

    public Tree (int val, Tree left, Tree right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public Tree (int val) {
      this.val = val;
    }
  }
}
