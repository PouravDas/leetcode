package com.leetcode.test6.subsequencestring;

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
	}
	public int numDistinct(String s, String t) {
		
		List<String> result = new ArrayList<>();
		String sub = "";
		
		powerSet(s, result, sub, 0);
		System.out.println(result);
		return (int) result.stream().filter(st->st.equals(t)).count();
	}

	private void powerSet(String s, List<String> result, String sub, int i) {
		
		if(i == s.length()) {
			result.add(sub);
			return;
		}
		powerSet(s, result, sub, i + 1);
		powerSet(s, result, sub + s.charAt(i), i + 1);
	}
	
	/*
	 * "bccbcdcabadabddbccaddcbabbaaacdba"
"bccbbdc"
	 */
	
}
