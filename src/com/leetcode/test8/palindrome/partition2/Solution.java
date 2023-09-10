package com.leetcode.test8.palindrome.partition2;

public class Solution {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.largestPal("aacaac"));
	}
	
	public int minCut(String s) {
		return largestPal(s) - 1;
	}
	
	private int largestPal(String st) {
		if(st.isEmpty())
			return 0;
		int len = -1;
		int s = -1;
		int e = -1;
		for(int i = 0; i < st.length(); i++) {
			int[] ixd = findPal(st, i);
			if(ixd[1] - ixd[0] > len) {
				len = ixd[1] - ixd[0];
				s = ixd[0];
				e = ixd[1];
			}
		}
		System.out.println(st.substring(s,e + 1));
		if(e == st.length() -1 )
			return 1 + largestPal(st.substring(0, s));
		else 
			return 1 + largestPal(st.substring(0, s)) + largestPal(st.substring(e + 1));
	}

	private int[] findPal(String s, int i) {
		int[] a1 = palLeng(s, i , i);
		int[] a2 = palLeng(s, i, i + 1);
		
		if(a1[1] - a1[0] > a2[1] - a2[0]) 
			return a1;
		else 
			return a2;
	}
	
	private int[] palLeng(String st, int s, int e) {
		while(s >= 0 && e < st.length() && st.charAt(s) == st.charAt(e)) {
			s--;
			e++;
		}
		
		int[] ans = {++s, --e};
		return ans;
	}
}
