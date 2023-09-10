package com.leetcode.test81.jumpGame7;

class Solution {
  Boolean ans = false;

  public boolean canReach (String s, int minJump, int maxJump) {
    if(s.charAt(s.length() -1) == '1')
      return false;
    isPossible(s.toCharArray(),0, minJump,maxJump);
    return ans;
  }

  private void isPossible (char[] arr, int i, int minJump, int maxJump) {

    if (i == arr.length - 1) {
      ans = true;
      return;
    }
    int min = i + minJump;
    int max = Math.min(i + maxJump, arr.length - 1);

    for (int j = max; j >= min; j--) {
      if (arr[j] == '0') {
        isPossible(arr, j, minJump, maxJump);
        if(ans)
          return;
      }
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    boolean ans =s.canReach("00111010",3,5);
    System.out.println(ans);
  }
}
