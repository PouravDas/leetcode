package com.leetcode.test39.maxNumPointsFromGridQueries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//hard leetcode #2503 not solved.. test case 1 and 2 passed 
public class Solution {
  public int[] maxPoints (int[][] grid, int[] queries) {

    int[] ans = new int[queries.length];
    Map<Integer, Integer> map = new HashMap<>();
    int[] sortedQueries = Arrays.copyOf(queries, queries.length);
    Arrays.sort(sortedQueries);

    boolean[][] visited = new boolean[grid.length][];
    for (int j = 0; j < visited.length; j++) {
      visited[j] = new boolean[grid[j].length];
    }

    Queue<Integer[]> queue = new PriorityQueue<>( (a, b) -> a[0] - b[0]);

    for (int i = 0; i < sortedQueries.length; i++) {
      Integer toAdd = 0;
      if (i != 0) {
        toAdd = map.get(sortedQueries[i - 1]);
      }
      if (map.get(sortedQueries[i]) != null) {
        continue;
      }
      map.put(sortedQueries[i], toAdd + getMaxPoint(grid, visited, queue, sortedQueries[i]));
    }
    
    for (int i = 0; i < queries.length; i++) {
      ans[i] = map.get(queries[i]);
    }

    return ans;
  }

  private int getMaxPoint (int[][] grid, boolean[][] visited, Queue<Integer[]> queue, int q) {

    int i = -1;
    int j = -1;
    int val = -1;
    if (queue.isEmpty()) {
      i = 0;
      j = 0;
      val = grid[i][j];
      visited[i][j] = true;
    } else {
      Integer[] arr = queue.peek();
      i = arr[1];
      j = arr[2];
      val = arr[0];
    }

    int point = 0;

    if (val < q) {
      point++;
      queue.poll();
      if (i - 1 > 0 && !visited[i - 1][j]) {
        Integer[] toAdd = {grid[i - 1][j], i - 1, j};
        queue.add(toAdd);
        visited[i - 1][j] = true;
        point += getMaxPoint(grid, visited, queue, q);
      }
      if (i + 1 < grid.length && !visited[i + 1][j]) {
        Integer[] toAdd = {grid[i + 1][j], i + 1, j};
        queue.add(toAdd);
        visited[i + 1][j] = true;
        point += getMaxPoint(grid, visited, queue, q);
      }
      if (j - 1 > 0 && !visited[i][j - 1]) {
        Integer[] toAdd = {grid[i][j - 1], i, j - 1};
        queue.add(toAdd);
        visited[i][j - 1] = true;
        point += getMaxPoint(grid, visited, queue, q);
      }
      if (j + 1 < grid[i].length && !visited[i][j + 1]) {
        Integer[] toAdd = {grid[i][j + 1], i, j + 1};
        queue.add(toAdd);
        visited[i][j + 1] = true;
        point += getMaxPoint(grid, visited, queue, q);
      }
      if(!queue.isEmpty()) {
        point += getMaxPoint(grid, visited, queue, q);
      }
    }
    return point;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
    int[] queries = {5, 6, 2};
    int[] ans = s.maxPoints(grid, queries);
    System.out.println(ans);
  }
}
