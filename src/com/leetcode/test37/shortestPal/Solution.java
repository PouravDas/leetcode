package com.leetcode.test37.shortestPal;

// Leet#214 hard
public class Solution {
  public String shortestPalindrome (String s) {

    if(s == null || s.isEmpty() )
      return s;
    
    int lastL = -1, lastR = -1;

    for (int i = 0; i <= s.length() / 2; i++) {

      if (findPal(s, i, i)) {
        lastL = i;
        lastR = i;
      }

      if (findPal(s, i, i + 1)) {
        lastL = i;
        lastR = i + 1;
      }
    }

    String add = toAdd(s, lastL + lastR + 1);

    return add + s;
  }

  private String toAdd (String s, int start) {
    String ans = "";

    for (int i = start; i < s.length(); i++)
      ans = s.charAt(i) + ans;

    return ans;
  }

  boolean findPal (String st, int l, int r) {
    while (l >= 0 && r < st.length() && st.charAt(l) == st.charAt(r)) {
      l--;
      r++;
    }
    return l == -1;
  }
  
  public static void main (String[] args) {
    Solution s = new Solution();
    
    String ans = s.shortestPalindrome("aacecaaa");
    System.out.println(ans);
  }
}
