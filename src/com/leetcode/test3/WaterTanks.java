package com.leetcode.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterTanks {

	public static void main(String[] args) {

		// int[] height = { 4, 2, 0, 3, 2, 5 };
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		WaterTanks wt = new WaterTanks();
		System.out.println(wt.trap(height));
	}

	public int trap(int[] height) {
		int ans = 0;
		List<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < height.length; i++) {
			list.add(this.new Pair(i, height[i]));
		}
		Collections.sort(list);

		Pair left = null, right = null;
		boolean flag = true;
		for (Pair curr : list) {
			if (flag) {
				left = right = curr;
				flag = false;
				continue;
			}

			if (curr.index > right.index) {
				ans += findWater(height, right, curr);
				right = curr;
			} else if (curr.index < left.index) {
				ans += findWater(height, curr, left);
				left = curr;
			}
		}

		return ans;
	}

	private static int findWater(int[] height, Pair start, Pair stop) {

		int result = 0;
		int h = Math.min(start.height, stop.height);

		for (int i = start.index + 1; i < stop.index; i++) {
			result += h - height[i];
		}
		return result;
	}

	class Pair implements Comparable<Pair> {
		final int index;
		final int height;

		Pair(int i, int h) {
			index = i;
			height = h;
		}

		@Override
		public int compareTo(Pair o) {
			return o.height - this.height;
		}

		@Override
		public String toString() {
			return "Pair [index=" + index + ", height=" + height + "]";
		}
	}
}
