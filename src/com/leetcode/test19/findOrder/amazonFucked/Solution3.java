package com.leetcode.test19.findOrder.amazonFucked;

import java.util.*;

// after doing DSA course
public class Solution3 {
  public String findOrder (String[] dict, int N, int K) {
    Map<Character, Node> map = new HashMap<>();
    Set<Character> visited = new HashSet<>();
    for (int i = 0; i < dict.length - 1; i++) {
      String firstWord = dict[i];
      String secondWord = dict[i + 1];
      int idx = 0;
      char firstChar, secondChar;
      while (idx < firstWord.length() && idx < secondWord.length()
          && firstWord.charAt(idx) == secondWord.charAt(idx)) {
        idx++;
      }
      if (idx == firstWord.length())
        continue;
      firstChar = firstWord.charAt(idx);
      secondChar = secondWord.charAt(idx);
      Node firstNode = map.getOrDefault(firstChar, new Node(firstChar));
      Node secondNode = map.getOrDefault(secondChar, new Node(secondChar));
      map.put(firstChar, firstNode);
      map.put(secondChar, secondNode);
      firstNode.neighbours.add(secondNode);
    }
    Stack<Character> stack = new Stack<>();
    for (Character c : map.keySet()) {
      if (!visited.contains(c)) {
        dfs(map.get(c), visited, stack);
      }
    }
    char[] ans = new char[stack.size()];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = stack.pop();
    }
    String ansDfs = new String(ans);
    //return ansDfs;

    //bfs Kahn's algo... based on inorder

    int size = map.size();
    Map<Node, Integer> inOrder = new HashMap<>();
    map.values().forEach(v -> inOrder.put(v, 0));
    map.values().forEach(v -> v.neighbours.forEach(n -> inOrder.compute(n, (key, val) -> val + 1)));
    List<Character> list = new ArrayList<>();
    bfs(inOrder, list);
    char[] an = new char[list.size()];
    int i = 0;
    for (Character c : list)
      an[i++] = c;
    return new String(an);
  }

  private void bfs (Map<Node, Integer> inOrder, List<Character> list) {
    Queue<Node> queue = new ArrayDeque<>();
    inOrder.entrySet().forEach(e -> {
      if (e.getValue() == 0)
        queue.offer(e.getKey());
    });

    while (!queue.isEmpty()){
      Node n = queue.poll();
      list.add(n.data);
      n.neighbours.forEach(neighbour -> {
        inOrder.compute(neighbour, (key,val) -> val - 1);
        if(inOrder.get(neighbour) == 0){
          queue.offer(neighbour);
        }
      });
    }
  }

  private void dfs (Node node, Set<Character> visited, Stack<Character> stack) {
    if (visited.contains(node.data))
      return;
    visited.add(node.data);
    node.neighbours.forEach(n -> dfs(n, visited, stack));
    stack.push(node.data);
  }

  private static class Node {
    char data;
    List<Node> neighbours;

    Node (char d) {
      data = d;
      neighbours = new ArrayList<>();
    }
  }
}
