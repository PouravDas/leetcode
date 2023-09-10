package com.leetcode.test25.addBinary;

public class Solution {

  public static void main (String[] args) {
    System.out.println((1 << 31) - 1);
    byte b  = -1;
    System.out.println(b);
    System.out.println(b >> 1);
    //System.out.println(b >>> 1);
    System.out.println(new Solution().addBinary("11", "1"));
  }

  public String addBinary (String a, String b) {

    int size = Math.max(a.length(), b.length()) + 1;
    char[] result = new char[size];
    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;
    int c = 0;
    for (int i = size - 1; i > -1; i--) {
      int d1 = 0, d2 = 0, r = 0;
      if (aIndex > -1)
        d1 = Integer.parseInt("" + a.charAt(aIndex--));
      if (bIndex > -1)
        d2 = Integer.parseInt("" + b.charAt(bIndex--));

      switch (d1 + d2 + c) {
        case 0:
          r = 0;
          c = 0;
          break;
        case 1:
          r = 1;
          c = 0;
          break;
        case 2:
          r = 0;
          c = 1;
          break;
        case 3:
          r = 1;
          c = 1;
      }
      result[i] = ("" + r).charAt(0);
    }
    String ans = new String(result);
    if (ans.charAt(0) == '0')
      return ans.substring(1);
    else
      return ans;
  }
}
