package com.leetcode.test7.coins;

import java.util.HashMap;

class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] coins = { 2 };
		int ans = s.coinChange(coins, 3);
		System.out.println(ans);

	}

	HashMap<Integer, Integer> dp = new HashMap<>();

	public int coinChange(int[] coins, int amount) {
		int ans = coinChange_r(coins, amount);
		if(ans == Integer.MAX_VALUE)
			return -1;
		return ans;
	}
	
	public int coinChange_r(int[] coins, int amount) {

		if (amount == 0) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;

		for (int c : coins) {

			int locAns;
			if (amount - c >= 0) {
				int ans_r;
				if(dp.get(amount - c) != null)
					ans_r = dp.get(amount - c);
				else 
					ans_r = coinChange_r(coins, amount - c); 
				if(ans_r == Integer.MAX_VALUE)
					continue;
				locAns = 1 + ans_r;
				ans = locAns < ans ? locAns : ans;
			}
		}
		dp.put(amount, ans);
		return ans;
	}
}
