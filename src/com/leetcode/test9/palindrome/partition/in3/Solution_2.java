package com.leetcode.test9.palindrome.partition.in3;

public class Solution_2 {

	boolean[][] dp;
	
	public static void main(String[] args) {
		Solution_2 s = new Solution_2();
		System.out.println(s.checkPartitioning("abcbdd"));
	}

	public boolean checkPartitioning(String s) {

		char[] c = s.toCharArray();
		dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				dp[j][i] = c[i] == c[j] && (i - j <= 2 || dp[j + 1][i - 1]);
			}
		}

		for (int i = 0; i < s.length() - 1; i++)
			for (int j = i + 1; j < s.length() - 1; j++) {
				if (dp[0][i] && dp[i + 1][j] && dp[j + 1][s.length() - 1])
					return true;
			}
		
		return false;
	}

}
