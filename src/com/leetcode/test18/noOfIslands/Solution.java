package com.leetcode.test18.noOfIslands;

public class Solution {

	public static void main(String[] args) {
		char[][] grid = {
		        {'1','1','1','1','0'},
		        {'1','1','0','1','0'},
		        {'1','1','0','0','0'},
		        {'0','0','0','0','0'}
		      };
		
		System.out.println(new Solution().numIslands(grid));

	}

	public int numIslands(char[][] grid) {

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					doBFS(grid, i, j);
				}
			}
		}

		return count;
	}

	private void doBFS(char[][] grid, int i, int j) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
			return;
		
		if(grid[i][j] == '0')
			return;

		grid[i][j] = '0';

		doBFS(grid, i, j - 1);
		doBFS(grid, i, j + 1);
		doBFS(grid, i - 1, j);
		doBFS(grid, i + 1, j);
	}
}
