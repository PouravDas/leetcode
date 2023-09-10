package com.leetcode.test233.sortVowels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//2785. Sort Vowels in a String
class Solution {
  public String sortVowels (String s) {
    char[] arr = s.toCharArray();
    List<Character> vowels = new ArrayList<>();
    List<Integer> vIndexs = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (isVowel(arr[i])) {
        vIndexs.add(i);
        vowels.add(arr[i]);
      }
    }
    Collections.sort(vowels);
    int idx = 0;
    for (int i : vIndexs){
      arr[i] = vowels.get(idx++);
    }
    return new String(arr);
  }

  private boolean isVowel (char c) {
    switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
        return true;
      default:
        return false;
    }
  }
}
