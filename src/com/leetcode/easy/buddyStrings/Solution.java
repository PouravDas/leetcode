package com.leetcode.easy.buddyStrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.buddyStrings("ab", "ba"));
	}
	public boolean buddyStrings(String s, String goal) {

		if (s.length() != goal.length())
			return false;

		int diffCount = 0;
		int idxFirst = -1, idxSecond = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				diffCount++;
				if (diffCount == 1)
					idxFirst = i;
				if (diffCount == 2)
					idxSecond = i;
			}
			if (diffCount > 2)
				return false;
		}

		if (diffCount == 2) {
			char[] sArr = s.toCharArray();

			char temp = sArr[idxSecond];
			sArr[idxSecond] = sArr[idxFirst];
			sArr[idxFirst] = temp;
			s = new String(sArr);
			return s.equals(goal);
		}

		if (diffCount == 0) {
			Set<Character> set = new HashSet<>();

			for (char c : s.toCharArray()) {
				if (set.contains(c))
					return true;
				set.add(c);
			}
		}

		return false;
	}
}
