package com.leetcode.test24.courseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Node> map = new HashMap<>();
		for (int[] pre : prerequisites) {
			int first = pre[1];
			int then = pre[0];
			
			if(first == then)
				return false;

			Node firstN = null;
			Node thenN = null;

			firstN = map.get(first);
			thenN = map.get(then);

			if (firstN == null) {
				firstN = new Node(first);
				map.put(first, firstN);
			}

			if (thenN == null) {
				thenN = new Node(then);
				map.put(then, thenN);
			}

			firstN.next.add(thenN);
		}

		Set<Integer> mem = new HashSet<>();

		boolean result = true;

		for (Map.Entry<Integer, Node> e : map.entrySet()) {
			Node node = e.getValue();
			Set<Integer> visited = new HashSet<>();
			
			result = hasLoop(node, visited, mem);
			if(!result)
				break;
		}

		return result;
	}

	private boolean hasLoop(Node node, Set<Integer> visited, Set<Integer> mem) {
		if(mem.contains(node.num))
			return true;
		
		if(visited.contains(node.num))
			return false;
		
		visited.add(node.num);
		
		for(Node n: node.next) {
			if(!hasLoop(n, visited, mem))
				return false;
		}
		
		mem.add(node.num);
		return true;
	}

	class Node {

		public Node(int num) {
			this.num = num;
		}

		public Node() {
		};

		int num;
		List<Node> next = new ArrayList<>();
	}
}
