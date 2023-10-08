package com.leetcode.test298.removeDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
  public String removeDuplicateLetters(String s) {
    int[] lastIdx = new int[26];
    boolean[] visited = new boolean[26];
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      lastIdx[c - 'a'] = i;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(visited[c - 'a']) continue;
      while (!stack.isEmpty()) {
        char prev = stack.peek();
        if (c - prev < 0 && lastIdx[prev - 'a'] > i) {
          stack.pop();
          visited[prev - 'a'] = false;
        } else {
          break;
        }
      }
      stack.push(c);
      visited[c - 'a'] = true;
    }
    char[] arr = new char[stack.size()];
    int i = stack.size();
    while (!stack.isEmpty()) {
      arr[--i] = stack.pop();
    }
    return new String(arr);
  }
}
