package com.leetcode.test6.subsequencestring;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {
	
	public static void main(String[] args) {
		Solution_2 s = new Solution_2();
		System.out.println(s.numDistinct("bccbcdcabadcbabbaaacdba", "bccbbdc"));
	}
	
	
	public int numDistinct(String s, String t) {
		
		List<String> result = new ArrayList<>();

		for(int i = 0; i< Math.pow(2, s.length()); i++) {
			String sub = "";
			for(int j = 0; j < s.length(); j++) {
				if((i & (1 << j)) != 0)
					sub += s.charAt(j);
			}
			
			if(sub.equals(t))
				result.add(sub);
		}
		return result.size();
	}

	/*
	 * "bccbcdcabadabddbccaddcbabbaaacdba"
"bccbbdc"
	 */
	


}
