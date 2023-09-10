package com.leetcode.test46.cheapestFlightsWithinKStops;

import java.util.*;

class Solution {
  public int findCheapestPrice (int n, int[][] flights, int src, int dst, int k) {

    Node[] seen = new Node[n];

    for (int[] flight : flights) {

      Node from = seen[flight[0]];
      if (from == null) {
        from = new Node(flight[0]);
        seen[flight[0]] = from;
      }

      Node to = seen[flight[1]];
      if (to == null) {
        to = new Node(flight[1]);
        seen[flight[1]] = to;
      }

      from.toCitys.add(to);
      from.prices.add(flight[2]);
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.totalPice));

    int[] stops = new int[n];
    Arrays.fill(stops, Integer.MAX_VALUE);
    if(seen[src] != null)
      queue.add(seen[src]);

    stops[src] = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.city == dst)
        return node.totalPice;

      if (stops[node.city]  < node.stops || node.stops >= k) {
        continue;
      }

      stops[node.city] = node.stops;

      for (int i = 0; i < node.toCitys.size(); i++) {
        Node next = node.toCitys.get(i);
        next = new Node(next);

        next.totalPice = node.totalPice + node.prices.get(i);
        next.stops = node.stops + 1;

        queue.add(next);
      }
    }
    return -1;
  }

  private static class Node {
    int city;
    List<Node> toCitys;
    List<Integer> prices;

    int totalPice;
    int stops;

    public Node (int c) {
      city = c;
      toCitys = new ArrayList<>();
      prices = new ArrayList<>();
      totalPice = 0;
      stops = -1;
    }

    public Node (Node n) {
      city = n.city;
      toCitys = new ArrayList<>(n.toCitys);
      prices = new ArrayList<>(n.prices);
      totalPice = n.totalPice;
      stops = n.stops;
    }

    @Override public String toString () {
      return "Node [city=" + city + ", totalPice=" + totalPice + ", stops=" + stops + "]";
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    //int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
    //int[][] flights = {{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}};
    //int ans = s.findCheapestPrice(13, flights, 10, 1, 10);
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    int ans = s.findCheapestPrice(3, flights, 0, 2, 1);
    System.out.println(ans);
  }
}
