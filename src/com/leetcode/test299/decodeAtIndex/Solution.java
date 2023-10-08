package com.leetcode.test299.decodeAtIndex;

class Solution {
  public String decodeAtIndex(String s, int k) {
    StringBuilder sb = new StringBuilder(k);
    for (int i = 0; i < s.length(); i++) {
      if(sb.length() >= k) break;
      char c = s.charAt(i);
      if(Character.isDigit(c)) {
        String st = sb.toString();
        int digit = Integer.parseInt("" + c);
        for (int j = 1; j < digit; j++) {
          sb.append(st);
          if(sb.length() >= k) break;
        }
      } else {
        sb.append(c);
      }
    }
    return "" + sb.charAt(k - 1);
  }
}
