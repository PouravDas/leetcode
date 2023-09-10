package com.leetcode.test5.palindrome.partition;

import java.util.ArrayList;
import java.util.List;

public class Solution_3 {

	public static void main(String[] args) {
		Solution_3 s = new Solution_3();
		System.out.println(s.partition("abaaccaf"));
	}

	public List<List<String>> partition(String s) {

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		boolean [][] dp = new boolean[s.length()][s.length()];
		dfs(result, 0, s, list, dp);

		return result;
	}

	private void dfs(List<List<String>> result, int start, String s, List<String> list, boolean[][] dp) {

		if (start >= s.length())
			result.add(new ArrayList<String>(list));

		for (int i = start; i < s.length(); i++) {
			if(s.charAt(start) == s.charAt(i) && (i - start < 3 || dp[start + 1][i - 1])) {
				dp[start][i] = true;
				String sub = s.substring(start, i + 1);
				list.add(sub);
				dfs(result, i + 1, s, list, dp);
				list.remove(list.size() - 1);
			}
		}

	}

}
