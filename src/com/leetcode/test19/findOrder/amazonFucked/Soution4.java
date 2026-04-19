package com.leetcode.test19.findOrder.amazonFucked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Soution4 {
  public String findOrder(String[] words) {
    Map<Character, Set<Character>> graph = new HashMap<>();

    boolean[] allChar = new boolean[26];
    for (String w : words) {
      for (char c : w.toCharArray()) {
        allChar[c - 'a'] = true;
      }
    }

    for (int i = 1; i < words.length; i++) {
      String w1 = words[i - 1];
      String w2 = words[i];
      boolean found = false;
      for (int j = 0; j < w1.length() && j < w2.length(); j++) {
        char c1 = w1.charAt(j);
        char c2 = w2.charAt(j);
        if (c1 != c2) {
          graph.compute(c1, (k, v) -> {
            if (v == null) v = new HashSet<>();
            v.add(c2);
            return v;
          });
          found = true;
          break;
        }
      }
      if (!found && w1.length() > w2.length()) return "";
    }
    Stack<Character> stack = new Stack<>();
    boolean[] seen = new boolean[26];
    for (int i = 0; i < 26; i++) {
      if (allChar[i]) {
        if (!dfs((char) ('a' + i), graph, seen, stack)) {
          return "";
        }
      }
    }

    char[] ans = new char[stack.size()];
    int i = 0;
    while (!stack.empty()) ans[i++] = stack.pop();
    return new String(ans);
  }

  private boolean dfs(char c, Map<Character, Set<Character>> graph, boolean[] seen, Stack<Character> stack) {
    if (seen[c - 'a']) return false;
    if (stack.contains(c)) return true;
    seen[c - 'a'] = true;
    Set<Character> edges = graph.get(c);
    if (edges != null) {
      for (char e : edges) {
        if (!dfs(e, graph, seen, stack)) return false;
      }
    }
    stack.push(c);
    seen[c - 'a'] = false;
    return true;
  }

  public static void main(String[] args) {
    Soution4 s = new Soution4();
    //String[] words = new String[]{"baa", "abcd", "abca", "cab", "cad"};
    String[] words = new String[]{"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
    String ans = s.findOrder(words);
    System.out.println(ans);
  }

}
