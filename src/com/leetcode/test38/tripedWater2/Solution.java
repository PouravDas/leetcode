package com.leetcode.test38.tripedWater2;

import java.util.PriorityQueue;

//hard 407. Trapping Rain Water II
/*
 * wrong solution
 * 
public class Solution {
  public int trapRainWater (int[][] heightMap) {
    int ans = 0;

    int[][] back = new int[heightMap.length][];
    int[][] front = new int[heightMap.length][];
    int[][] left = new int[heightMap.length][];
    int[][] right = new int[heightMap.length][];

    for (int i = 0; i < heightMap.length; i++) {
      if (i == 0) {
        back[i] = heightMap[i];
      } else {
        back[i] = new int[heightMap[i].length];
      }
      left[i] = new int[heightMap[i].length];
      for (int j = 0; j < heightMap[i].length; j++) {

        // for back array
        if (i == 0) {

        } else if (back[i - 1][j] < heightMap[i][j]) {
          back[i][j] = heightMap[i][j];
        } else {
          back[i][j] = back[i - 1][j];
        }

        // for left array
        if (j == 0) {
          left[i][j] = heightMap[i][j];
        } else if (left[i][j - 1] < heightMap[i][j]) {
          left[i][j] = heightMap[i][j];
        } else {
          left[i][j] = left[i][j - 1];
        }
      }
    }

    for (int i = heightMap.length - 1; i >= 0; i--) {

      if (i == heightMap.length - 1) {
        front[i] = heightMap[i];
      } else {
        front[i] = new int[heightMap[i].length];
      }
      right[i] = new int[heightMap[i].length];
      for (int j = heightMap[i].length - 1; j >= 0; j--) {

        // for front array
        if (i == heightMap.length - 1) {

        } else if (front[i + 1][j] < heightMap[i][j]) {
          front[i][j] = heightMap[i][j];
        } else {
          front[i][j] = front[i + 1][j];
        }

        // for right array
        if (j == heightMap[i].length - 1) {
          right[i][j] = heightMap[i][j];
        } else if (right[i][j + 1] < heightMap[i][j]) {
          right[i][j] = heightMap[i][j];
        } else {
          right[i][j] = right[i][j + 1];
        }
      }
    }


    for (int i = 0; i < heightMap.length; i++) {
      for (int j = 0; j < heightMap[i].length; j++) {

        ans += minOf(back[i][j], front[i][j], left[i][j], right[i][j]) - heightMap[i][j];
      }
    }

    return ans;
  }

  private int minOf (int i, int j, int k, int l) {
    return Math.min(i, Math.min(j, Math.min(k, l)));
  }

  public static void main (String[] args) {
    int[][] heightMap =
        // {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
    Solution s = new Solution();
    System.out.println(s.trapRainWater(heightMap));
  }
}
*/



public class Solution {
  public int trapRainWater (int[][] heightMap) {

    int water = 0;

    boolean[][] visited = new boolean[heightMap.length][];
    for (int i = 0; i < heightMap.length; i++) {
      visited[i] = new boolean[heightMap[i].length];
    }

    PriorityQueue<Cell> pQ = new PriorityQueue<>();

    for (int i = 0; i < heightMap.length; i++) {
      if (i == 0 || i == heightMap.length - 1) {
        for (int j = 0; j < heightMap[i].length; j++) {
          pQ.add(new Cell(i, j, heightMap[i][j]));
          visited[i][j] = true;
        }
      } else {
        pQ.add(new Cell(i, 0, heightMap[i][0]));
        visited[i][0] = true;
        pQ.add(new Cell(i, heightMap[i].length - 1, heightMap[i][heightMap[i].length - 1]));
        visited[i][heightMap[i].length - 1] = true;
      }
    }

    while (!pQ.isEmpty()) {
      Cell cell = pQ.poll();

      Cell neighbourCell = leftCell(cell, heightMap, visited);
      if (neighbourCell != null) {
        if (neighbourCell.height < cell.height) {
          water += cell.height - neighbourCell.height;
          neighbourCell.height = cell.height;
        }
        pQ.add(neighbourCell);
        visited[neighbourCell.row][neighbourCell.column] = true;
      }
      neighbourCell = rightCell(cell, heightMap, visited);
      if (neighbourCell != null) {
        if (neighbourCell.height < cell.height) {
          water += cell.height - neighbourCell.height;
          neighbourCell.height = cell.height;
        }
        pQ.add(neighbourCell);
        visited[neighbourCell.row][neighbourCell.column] = true;
      }
      neighbourCell = upCell(cell, heightMap, visited);
      if (neighbourCell != null) {
        if (neighbourCell.height < cell.height) {
          water += cell.height - neighbourCell.height;
          neighbourCell.height = cell.height;
        }
        pQ.add(neighbourCell);
        visited[neighbourCell.row][neighbourCell.column] = true;
      }
      neighbourCell = downCell(cell, heightMap, visited);
      if (neighbourCell != null) {
        if (neighbourCell.height < cell.height) {
          water += cell.height - neighbourCell.height;
          neighbourCell.height = cell.height;
        }
        pQ.add(neighbourCell);
        visited[neighbourCell.row][neighbourCell.column] = true;
      }
    }

    return water;
  }

  private Cell leftCell (Cell cell, int[][] heightMap, boolean[][] visited) {
    int i = cell.row;
    int j = cell.column - 1;

    if (j >= 0 && !visited[i][j]) {
      return new Cell(i, j, heightMap[i][j]);
    }

    return null;
  }

  private Cell rightCell (Cell cell, int[][] heightMap, boolean[][] visited) {
    int i = cell.row;
    int j = cell.column + 1;

    if (j < heightMap[i].length && !visited[i][j]) {
      return new Cell(i, j, heightMap[i][j]);
    }

    return null;
  }

  private Cell upCell (Cell cell, int[][] heightMap, boolean[][] visited) {
    int i = cell.row - 1;
    int j = cell.column;

    if (i >= 0 && !visited[i][j]) {
      return new Cell(i, j, heightMap[i][j]);
    }

    return null;
  }

  private Cell downCell (Cell cell, int[][] heightMap, boolean[][] visited) {
    int i = cell.row + 1;
    int j = cell.column;

    if (i < heightMap.length && !visited[i][j]) {
      return new Cell(i, j, heightMap[i][j]);
    }

    return null;
  }

  private class Cell implements Comparable<Cell> {
    public int row;
    public int column;
    public int height;

    public Cell(int row, int column, int height) {
      super();
      this.row = row;
      this.column = column;
      this.height = height;
    }

    @Override
    public int compareTo (Cell c) {
      return this.height - c.height;
    }

    @Override
    public String toString () {
      return "Cell [row=" + row + ", column=" + column + ", height=" + height + "]";
    }
  }

  public static void main (String[] args) {
    int[][] heightMap =
         {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        //{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
    Solution s = new Solution();
    System.out.println(s.trapRainWater(heightMap));
  }
}
