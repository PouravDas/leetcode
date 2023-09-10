package com.leetcode.test9.palindrome.partition.in3;

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.checkPartitioning("bbab"));
	}

	Boolean[][] dp;
	boolean ans;
	
	/*
	public boolean checkPartitioning(String s) {
        
		dp = new boolean[s.length()][s.length()];
		isBy(s, 0, s.length() - 1 , 3);		
		return ans;
    }
	
	private void isBy(String s, int start, int end, int part) {
		
		if(start > end && part == 0) {
			ans = true;
			return;
		}
		
		for(int i= start; i <= end; i++) {
			for(int j = start; j <= i; j++) {
				if(s.charAt(start) == s.charAt(j) && (j - start <= 2 || dp[start + 1][j - 1])) {
					dp[start][j] = true;
					isBy(s, j + 1, end, part -1);
				}
			}
		}
	}
	
	*/
	
	
	public boolean checkPartitioning(String s) {
		dp = new Boolean[s.length()][s.length()];
		for (int i = 0; i < s.length() - 2; i++) {
			if (isPal(s, 0, i)) {
				for (int j = s.length() - 1; j > i + 1; j--) {
					if (isPal(s, j, s.length() - 1) && isPal(s, i + 1, j - 1)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isPal(String st, int s, int e) {
		int s_ = s;
		int e_ = e;
		if (dp[s][e] != null)
			return dp[s][e];
		while (s < e) {
			if(st.charAt(s) != st.charAt(e))
				return false;
			s++;
			e--;
			if (dp[s][e] != null)
				return dp[s][e];
		}

		dp[s_][e_] = true;
		return true;
	}

}
