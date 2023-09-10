package com.leetcode.test46.cheapestFlightsWithinKStops;

import java.util.*;

class Solution2 {
  public int findCheapestPrice (int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    for (int[] i : flights)
      adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] {i[1], i[2]});

    int[] stops = new int[n];
    Arrays.fill(stops, Integer.MAX_VALUE);
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    // {dist_from_src_node, node, number_of_stops_from_src_node}
    pq.offer(new int[] {0, src, 0});

    while (!pq.isEmpty()) {
      int[] temp = pq.poll();
      int dist = temp[0];
      int node = temp[1];
      int steps = temp[2];
      // We have already encountered a path with a lower cost and fewer stops,
      // or the number of stops exceeds the limit.
      if (steps > stops[node] || steps > k + 1)
        continue;
      stops[node] = steps;
      if (node == dst)
        return dist;
      if (!adj.containsKey(node))
        continue;
      for (int[] a : adj.get(node)) {
        pq.offer(new int[] {dist + a[1], a[0], steps + 1});
      }
    }
    return -1;
  }

  public static void main (String[] args) {
    Solution2 s = new Solution2();
    //int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    //int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
   // int[][] flights = {{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}};
   // int ans = s.findCheapestPrice(13, flights, 10, 1, 10);
    //int ans = s.findCheapestPrice(4, flights, 0, 3, 1);

    int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
    int ans = s.findCheapestPrice(3, flights, 0, 2, 1);
    System.out.println(ans);
  }
}
