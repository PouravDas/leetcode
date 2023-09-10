package com.leetcode.test21.courseSchedule.topSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//210. Course Schedule II
public class Solution {

	boolean noAns = false;

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int ans[] = new int[numCourses];

		if (prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++)
				ans[i] = numCourses - i - 1;
		}

		Map<Integer, Node> map = new HashMap<>();

		for (int[] arr : prerequisites) {
			int forCourse = arr[0];
			Node forNode = map.get(forCourse);

			if (forNode == null) {
				forNode = new Node(forCourse);
				map.put(forCourse, forNode);
			}

			for (int i = 1; i < arr.length; i++) {
				int needed = arr[i];

				Node neededNode = map.get(needed);

				if (neededNode == null) {
					neededNode = new Node(needed);
					map.put(needed, neededNode);
				}
				forNode.addj.add(neededNode);
			}
		}

		Set<Integer> done = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		map.forEach((i, n) -> dfs(n, new HashSet<>(), done, list));
		if (noAns) {
			return new int[] {};
		}
		
		List<Integer> toadd = new ArrayList<Integer>();
		
		for (int i = 0; i < numCourses; i++) {
			if(!list.contains(i)) {
				toadd.add(i);
			}
		}
		int idx = 0;
		for (int i : toadd) {
			ans[idx++] = i;
		}
		for (int i : list) {
			ans[idx++] = i;
		}
		return ans;
	}

	private void dfs(Node n, Set<Integer> seen, Set<Integer> done, List<Integer> list) {
		if (noAns || done.contains(n.v))
			return;
		if (seen.contains(n.v)) {
			noAns = true;
			return;
		}

		seen.add(n.v);
		n.addj.forEach(a -> dfs(a, seen, done, list));
		done.add(n.v);
		list.add(n.v);
	}

	class Node {
		int v;
		List<Node> addj;

		public Node(int i) {
			v = i;
			addj = new ArrayList<>();
		}
	}
}
