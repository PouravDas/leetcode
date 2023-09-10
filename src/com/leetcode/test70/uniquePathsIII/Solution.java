package com.leetcode.test70.uniquePathsIII;

public class Solution {
  public int uniquePathsIII (int[][] grid) {

    int startX = 0, startY = 0;
    int endX = 0, endY = 0;

    int emptyCells = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          startX = i;
          startY = j;
        } else if (grid[i][j] == 2) {
          endX = i;
          endY = j;
        } else if (grid[i][j] == 0) {
          emptyCells++;
        }
      }
    }
    return findPath(new boolean[grid.length][grid[0].length],grid, startX,startY,endX,endY,0,emptyCells);
  }

  private int findPath(boolean[][] seen, int[][] grid, int i, int j, int endX, int endY, int count, int target){
    if(i< 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return 0;
    } else if(seen[i][j]) {
      return 0;
    } else if(count -1 == target ) {
      if(i == endX && j == endY) {
        return 1;
      } else {
        return 0;
      }
    } else if(grid[i][j] == -1) {
      return 0;
    } else {
      seen[i][j] = true;
      return findPath(copySeen(seen),grid, i-1,j,endX,endY,count + 1,target) +
          findPath(copySeen(seen),grid, i,j-1,endX,endY,count + 1,target) +
          findPath(copySeen(seen),grid, i+1,j,endX,endY,count + 1,target) +
          findPath(copySeen(seen),grid, i,j+1,endX,endY,count + 1,target);
    }
  }

  private boolean[][] copySeen (boolean[][] seen) {
    boolean[][] newArr = new boolean[seen.length][seen[0].length];
    for (int i = 0; i < seen.length; i++) {
      System.arraycopy(seen[i], 0, newArr[i], 0, seen[i].length);
    }
    return newArr;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //s.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
    int ans = s.uniquePathsIII(new int[][]{{0,1},{0,2}});
    System.out.println(ans);
  }
}
