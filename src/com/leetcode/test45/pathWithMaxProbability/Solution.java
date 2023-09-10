package com.leetcode.test45.pathWithMaxProbability;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public double maxProbability (int n, int[][] edges, double[] succProb, int start, int end) {

    Node[] seen = new Node[n];

    for (int i = 0; i < edges.length; i++) {
      Node node = seen[edges[i][0]];
      if (node == null) {
        node = new Node(edges[i][0]);
        seen[edges[i][0]] = node;
      }
      Node next = seen[edges[i][1]];
      if (next == null) {
        next = new Node(edges[i][1]);
        seen[edges[i][1]] = next;
      }
      node.nextNodes.add(next);
      node.nextProbs.add(succProb[i]);
      
      next.nextNodes.add(node);
      next.nextProbs.add(succProb[i]);
    }

    if (seen[end] == null || seen[start] == null) {
      return 0;
    }

    Queue<Node> pq = new PriorityQueue<>( (a, b) -> {
      if (a.prob < b.prob)
        return 1;
      else
        return -1;
    });
    
    seen[start].prob = 1;
    pq.add(seen[start]);
    
    // reusing
    seen = new Node[n];
    seen[start] = pq.peek();

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      
      if(node.val == end ) {
        return node.prob;
      }

      for (int i = 0; i < node.nextNodes.size(); i++) {
        Node next = node.nextNodes.get(i);
        double newProb = node.prob * node.nextProbs.get(i);
        if(newProb > next.prob) {
          if(seen[next.val] != null)
            pq.remove(next);
          else
            seen[next.val] = next;
          next.prob = newProb;
          pq.add(next);
        }
      }
    }
    return 0;
  }

  private static class Node {
    int val;
    double prob;
    List<Node> nextNodes;
    List<Double> nextProbs;

    public Node(int v) {
      val = v;
      prob = 0;
      nextNodes = new ArrayList<>();
      nextProbs = new ArrayList<>();
    }

    @Override
    public int hashCode () {
      final int prime = 31;
      int result = 1;
      result = prime * result + val;
      return result;
    }

    @Override
    public boolean equals (Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Node other = (Node) obj;
      if (val != other.val)
        return false;
      return true;
    }

    @Override
    public String toString () {
      return "Node [val=" + val + ", prob=" + prob + ", nextNodes=" + nextNodes + ", nextProbs="
          + nextProbs + "]";
    }
  }
  
  public static void main (String[] args) {
    /*
     * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
     */
    
    Solution s = new Solution();
    int[][] edges = {{0,1},{1,2},{0,2}};
    double[] succProb = {0.5,0.5,0.2};
    double ans = s.maxProbability(3, edges, succProb, 0, 2);
    System.out.println(ans);
  }
}
