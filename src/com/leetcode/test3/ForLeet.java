package com.leetcode.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class ForLeet {

	public static void main(String[] args) {

		// int[] height = { 4, 2, 0, 3, 2, 5 };
		// int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		WaterTanks wt = new WaterTanks();
		System.out.println(wt.trap(height));
	}

	public int trap(int[] height) {
		int ans = 0;
		List<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < height.length; i++) {
			Integer[] pair = { height[i], i };
			list.add(pair);
		}
		list.sort((p1, p2) -> p2[0] - p1[0]);

		Integer[] left = null, right = null;
		boolean flag = true;
		for (Integer[] curr : list) {
			if (flag) {
				left = right = curr;
				flag = false;
				continue;
			}

			if (curr[1] > right[1]) {
				ans += findWater(height, right, curr);
				right = curr;
			} else if (curr[1] < left[1]) {
				ans += findWater(height, curr, left);
				left = curr;
			}
		}

		return ans;
	}

	private static int findWater(int[] height, Integer[] start, Integer[] stop) {

		int result = 0;
		int h = Math.min(start[0], stop[0]);

		for (int i = start[1] + 1; i < stop[1]; i++) {
			result += h - height[i];
		}
		return result;
	}
}
