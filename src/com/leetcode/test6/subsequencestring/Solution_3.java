package com.leetcode.test6.subsequencestring;

public class Solution_3 {

	public static void main(String[] args) {
		Solution_3 s = new Solution_3();
		System.out.println(s.numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));

		
	}

	Integer dp[][];

	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
			return 0;
		dp = new Integer[s.length() + 1][t.length() + 1];
		int ans = solve(0, 0, s, t);
		return ans;
	}

	int solve(int i, int j, String s, String t) {
		if (j == t.length())// rest s chars can be deleted to make s=t in 1 way
			return 1;

		if (i == s.length())// t still not finisehd but s over so no way we can match now
			return 0;

		if (dp[i][j] != null)
			return dp[i][j];

		if (s.charAt(i) == t.charAt(j))
			return dp[i][j] = solve(i + 1, j + 1, s, t) + solve(i + 1, j, s, t);// rest str match ways +del and match
																				// ways
		else
			return dp[i][j] = solve(i + 1, j, s, t);// del and match ways
	}

	/*
	 * "bccbcdcabadabddbccaddcbabbaaacdba" "bccbbdc"
	 */

}
