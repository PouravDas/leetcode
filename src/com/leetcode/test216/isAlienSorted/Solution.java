package com.leetcode.test216.isAlienSorted;

//953. Verifying an Alien Dictionary
class Solution {
  public boolean isAlienSorted (String[] words, String order) {
    int[] ord = new int[26];
    int i = 0;
    for (char c : order.toCharArray()) {
      ord[c - 'a'] = i++;
    }
    for (i = 0; i < words.length - 1; i++) {
      String s1 = words[i];
      String s2 = words[i + 1];
      int idx = 0;
      while (idx < s1.length() && idx < s2.length()) {
        if (ord[s1.charAt(idx) - 'a'] == ord[s2.charAt(idx) - 'a']) {
          idx++;
        }
        else if (ord[s1.charAt(idx) - 'a'] < ord[s2.charAt(idx) - 'a'])
          break;
        else
          return false;
      }
      if (s1.length() > s2.length())
        return false;
    }
    return true;
  }

  public static void main (String[] args) {

  }
}
