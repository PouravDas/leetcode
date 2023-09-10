package com.leetcode.test13.closestSubsequenceSum;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(binarySearch(new int[] {2,3,4},4));
	}

	int ans = Integer.MAX_VALUE;

	public int minAbsDifference(int[] nums, int goal) {

		findDiff(0, nums, 0, goal);
		return ans;
	}

	private void findDiff(int sum, int[] nums, int idx, int goal) {

		ans = Math.min(ans, Math.abs(sum - goal));

		if (ans == 0)
			return;

		if (idx == nums.length)
			return;

		findDiff(sum, nums, idx + 1, goal);
		findDiff(sum + nums[idx], nums, idx + 1, goal);
	}

	public int[] twoSum(int[] nums, int target) {

		int[] r = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int first = nums[i];
			int second = target - first;
			for (int j = 0; j < nums.length; j++) {
				if (i == j)
					continue;

				if (second == nums[j]) {
					r[0] = i;
					r[1] = j;
					return r;
				}

			}
		}
		return r;
	}

	public int[] twoSum2(int[] numbers, int target) {

		for (int i = 0; i < numbers.length; i++) {
			int find = target - numbers[i];
			int pos = binarySearch(numbers, find);
			if (pos < 0 || pos == i)
				continue;

			return new int[] { i + 1, pos + 1 };
		}

		return null;
	}

	private static int binarySearch(int[] numbers, int find) {
		int first = 0;
		int last = numbers.length - 1;
		int mid = last / 2;

		while (first <= last) {
			if (numbers[mid] == find)
				return mid;
			if (numbers[mid] < find)
				first = mid + 1;
			else
				last = mid - 1;

			mid = (last + first) / 2;
		}

		return -1;
	}
	
	
	

}
