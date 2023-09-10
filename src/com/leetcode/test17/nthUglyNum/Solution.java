package com.leetcode.test17.nthUglyNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) {
		//System.out.println(new Solution().nthUglyNumber(8));
		
		System.out.println(new Solution().nthSuperUglyNumber(12, new int[] {2,7,13,19}));
	}

	private List<Integer> list = new ArrayList<>();
	private HashSet<Integer> set = new HashSet<>();
	private int n;

	public int nthUglyNumber(int n) {
		set.add(1);
		list.add(1);
		this.n = n;

		getNewNums(list);

		System.out.println(list);
		return list.get(n - 1);
	}

	private void getNewNums(List<Integer> list) {
		if (this.list.size() > n * 1.5)
			return;

		List<Integer> l2 = new ArrayList<>();
		for (int v : list) {

			if (!set.contains(v * 2)) {
				l2.add(v * 2);
				set.add(v * 2);
			}

			if (!set.contains(v * 3)) {
				l2.add(v * 3);
				set.add(v * 3);
			}

			if (!set.contains(v * 5)) {
				l2.add(v * 5);
				set.add(v * 5);
			}
		}
		Collections.sort(l2);
 		this.list = mergeSort(this.list, l2);
		getNewNums(l2);
	}

	private List<Integer> mergeSort(List<Integer> l1, List<Integer> l2) {
		int i1 = 0;
		int i2 = 0;

		int st = l1.size() + l2.size();
		List<Integer> list = new ArrayList<Integer>(st);

		while (i1 < l1.size() || i2 < l2.size()) {
			if (i1 == l1.size())
				list.add(l2.get(i2++));
			else if (i2 == l2.size())
				list.add(l1.get(i1++));

			else if (l1.get(i1) > l2.get(i2))
				list.add(l2.get(i2++));
			else
				list.add(l1.get(i1++));
		}
		return list;
	}
	
	public int numSquares(int n) {
        
		List<Integer> sqrs = new ArrayList<Integer>();
		int s = 1;
		while(s*s <= n) {
			sqrs.add(s*s);
			s++;
		}
		
		return numSquares(sqrs, n, new HashMap<Integer, Integer>());
    }
	
	private int numSquares(List<Integer> choices, int target, Map<Integer, Integer> dp) {
		
		if(target == 0)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int c : choices) {
			
			int locAns;
			if(target - c >= 0) {
				
				if(dp.containsKey(target - c))
					locAns = 1 + dp.get(target - c);
				else {
					locAns = 1 + numSquares(choices, target - c, dp);
				}
				ans = Math.min(locAns, ans);
			}
		}
		
		dp.put(target, ans);
		return ans;
	}
	
	public int numSquares_(int n) {
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			int ans = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++) {
				ans = Math.min(ans, 1 + dp[i - j*j]);
			}
			dp[i] = ans;
		}
		return dp[n];
	}
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] arr = new int[n];
        int[] p = new int[primes.length + 1];
        
        arr[0] = 1;
        
        for(int i = 1; i < n; i++ ) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            
            for(int j = 0; j < primes.length; j++) {
                int ans = primes[j] *  arr[p[j]];
                if(ans < min ){
                    min = ans;
                    idx = j;
                }
            }
            arr[i] = min;
            p[idx] += 1;
        }
        
        System.out.println(arr);
        
        return arr[n -1];
    }
	
}
