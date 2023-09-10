package com.leetcode.test20.boms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Bomb> map;

	public int maximumDetonation(int[][] bombs) {

		map = new HashMap<Integer, Bomb>(bombs.length);

		for (int i = 0; i < bombs.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < bombs.length; j++) {
				if (i == j)
					continue;
				if (bombInRange(bombs[i], bombs[j]))
					set.add(j);
			}
			map.put(i, new Bomb(i, set));
		}

		int ans = 0;

		for (int i = 0; i < bombs.length; i++) {
			IntWrapper count = new IntWrapper();
			getBombCount(i, new HashSet<Integer>(), count);
			ans = Math.max(ans, count.i);
		}

		return ans;
	}

	private void getBombCount(int bombNo, Set<Integer> done, IntWrapper count) {
		if (done.contains(bombNo))
			return;
		count.i++;
		done.add(bombNo);
		map.get(bombNo).triggersBombs.forEach(b -> getBombCount(b, done, count));
	}

	private boolean bombInRange(int[] p1, int[] p2) {
		return bombInRange(p1[0], p1[1], p2[0], p2[1], p1[2]);
	}

	class Bomb {
		int bombNum;
		Set<Integer> triggersBombs;

		public Bomb(int bombNum, Set<Integer> triggersBombs) {
			this.bombNum = bombNum;
			this.triggersBombs = triggersBombs;
		}
	}

	class IntWrapper {
		int i;
	}

	private boolean bombInRange(int x1, int y1, int x2, int y2, int r) {
		double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
		return distance <= r;
	}

}
