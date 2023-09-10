package com.leetcode.test18.noOfIslands;

public class SimilarQues {
	
	public static void main(String[] args) {
		int[][] grid = {
		        {1,1,1,1,0},
		        {1,1,0,1,0},
		        {1,1,0,0,0},
		        {0,0,0,0,0}
		      };
		
		System.out.println(new SimilarQues().maxAreaOfIsland(grid));
	}
	
    public int maxAreaOfIsland(int[][] grid) {

		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					Area area = new Area();
					doBFS(grid, i, j, area);
                    ans = Math.max(ans, area.a);
				}
			}
		}

		return ans;
	}

	private void doBFS(int[][] grid, int i, int j, Area area) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
			return;
		
		if(grid[i][j] == 0)
			return;

		grid[i][j] = 0;
        area.a++;

		doBFS(grid, i, j - 1, area);
		doBFS(grid, i, j + 1, area);
		doBFS(grid, i - 1, j, area);
		doBFS(grid, i + 1, j, area);
	}
	
	class Area{
		int a;
	}
}
