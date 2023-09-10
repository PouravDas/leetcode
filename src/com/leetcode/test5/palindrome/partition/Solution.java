package com.leetcode.test5.palindrome.partition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.partition("aba"));
	}
	
	List<List<String>> list_ = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		
		
		for (char c :s.toCharArray()) {
			if(list_.isEmpty()) {
				List<String> l = new ArrayList<String>(1);
				l.add("" + c);
				list_.add(l);
				continue;
			}
			List<List<String>> list_n = new ArrayList<List<String>>();
			
			for(List<String> li : list_) {
				List<String> l_n = new ArrayList<String>(li);
				int last = l_n.size() - 1;
				l_n.set(last, l_n.get(l_n.size() - 1) + c);
				li.add("" + c);
				list_n.add(l_n);
			}
			list_.addAll(list_n);
		}
		
		return list_.stream().filter(l -> {
			for(String st :l) {
				if(!isPal(st))
					return false;
			}
			return true;
		}).collect(Collectors.toList());
	}

	private boolean isPal(String s) {
		if (s.length() < 2)
			return true;
		for (int i = 0, j = s.length() -1 ; i < j; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}
}
