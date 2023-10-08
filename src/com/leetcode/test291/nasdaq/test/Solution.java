package com.leetcode.test291.nasdaq.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  public static String[] getTopStocks(String[] stocks, float[][] prices) {
    // Write your code here
    // To debug: System.err.println("Debug messages...");
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    Map<String, Pair> map = new HashMap<>();
    for(String s : stocks) {
      map.put(s, new Pair(s, 0));
    }
    for(int i = 0; i < prices.length; i++) {
      for(int j = 0; j < prices[i].length; j++) {
        map.get(stocks[j]).avgPrice += prices[i][j];
      }
    }
    for(String s : stocks) {
      map.get(s).avgPrice /= prices.length;
    }
    map.entrySet().forEach(e -> pq.offer(e.getValue()));
    String[] ans = new String[3];
    for(int i = 0; i < 3; i++){
      if(!pq.isEmpty()) {
        ans[i] = pq.poll().stock;
      }
    }
    return ans;
  }

  private static class Pair implements Comparable<Pair> {
    String stock;
    float avgPrice;

    Pair(String s, float p) {
      stock = s;
      avgPrice = p;
    }

    public int compareTo(Pair p) {
      return this.avgPrice - p.avgPrice > 0 ? 1 : -1;
    }
  }

  /* Ignore and do not change the code below */
  public static void main(String args[]) {
    Solution s = new Solution();
    double d = 98.89923892;
    getTill4(d);
    s.getTopStocks(new String[] {"a", "b" , "c", "d"}, new float[][] {{1.2f,2.2f,3.3f,2.2f},{1.2f,2.2f,3.3f,5.2f}});
  }
  /* Ignore and do not change the code above */

  private static String getTill4(double total) {
    String st = "" + total;
    return st.substring(0, st.indexOf('.') + 5);
  }
}
