package com.leetcode.test9.palindrome.partition.in4;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.palindromePartition("aabbc", 3));
	}

	public int palindromePartition(String s, int k) {

		if (s.length() == k)
			return 0;

		int[][] toPal = new int[s.length()][s.length()];
		int[][] dp = new int[k + 1][s.length()];

		for (int i = 0; i < s.length(); i++)
			for (int j = i; j < s.length(); j++)
				toPal[i][j] = findCost(s, i, j);

		for (int i = 0; i < s.length(); i++)
			dp[1][i] = toPal[0][i];

		for (int parts = 2; parts <= k; parts++) {
			for (int index = parts - 1; index < s.length() - k + parts; index++) {
				if (parts == index + 1) {
					dp[parts][index] = 0;
					continue;
				}

				int min = s.length();

				for (int l = parts - 2; l < index; l++) {
					min = Math.min(min, dp[parts - 1][l] + toPal[l + 1][index]);
				}

				dp[parts][index] = min;
			}
		}

		return dp[k][s.length() - 1];
	}

	private int findCost(String s, int i, int j) {
		if (i == j)
			return 0;
		int cost = 0;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				cost++;
			i++;
			j--;
		}
		return cost;
	}

}
