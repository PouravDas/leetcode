package com.leetcode.test2;

public class Solution {

	public static void main(String[] args) {
		int[] t = { 7, 8, 9, 11, 12 };
		int x = firstMissingPositive(t);

		System.out.println(x);
	}

	public static int firstMissingPositive(int[] nums) {
		int s = Integer.MAX_VALUE;
		int m = 0;
		int sum = 0;

		for (int n : nums) {
			if (n <= 0)
				continue;
			if (n > m)
				m = n;
			if (n < s)
				s = n;

			sum += n;
		}

		System.out.println("s = " + s);
		System.out.println("m = " + m);
		System.out.println("sum = " + sum);

		int result;
		if (s == 1) {
			result = sumOfN(m) - sum;
		} else
			result = sumOfN(m) - sumOfN(s - 1) - sum;
		if (result == 0) {
			return m + 1;
		} else
			return result;

	}

	public static int sumOfN(int n) {
		return (n * (n + 1)) / 2;
	}
}
