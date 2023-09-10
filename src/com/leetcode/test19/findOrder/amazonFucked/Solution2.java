package com.leetcode.test19.findOrder.amazonFucked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution2 {

	public static void main(String[] args) {
		String[] inputs = {"baa","abcd","abca","cab","cad"};
		//String[] inputs = Solution.inputs_.split(" ");
		System.out.println(new Solution3().findOrder(inputs, 0, 0));
	}

	boolean noAns = false;
	
	public String findOrder(String[] dict, int N, int K) {
		
		Map<Character, MyNode> map = new HashMap<>();
		
		for (int i = 0; i < dict.length - 1; i++) {
			String current = dict[i];
			String next = dict[i + 1];
			
			int l = Math.min(current.length(), next.length());
			
			char start = '0';
			char end = '0';
			for(int j =0; j< l; j++) {
				if(current.charAt(j) != next.charAt(j)) {
					start = current.charAt(j);
					end = next.charAt(j);
					break;
				}
			}
			
			if(start == '0')
				continue;
			
			System.out.println(start + " -> " + end);
			MyNode startNode = map.get(start);
			MyNode endNode = map.get(end);
			
			if(startNode == null) {
				startNode = new MyNode(start);
				map.put(start, startNode);
			}
			
			if(endNode == null) {
				endNode = new MyNode(end);
				map.put(end, endNode);
			}
			
			startNode.addNext(endNode);
		}
		
		Stack<Character> stack = new Stack<>();
		Set<Character> processed = new HashSet<>();
		
		
		map.forEach((c, node) ->{
			dfs(node, processed, new HashSet<>(), stack);
		});
		
		if(noAns)
			return "";
		else {
			StringBuilder ans = new StringBuilder(stack.size());
			while(!stack.isEmpty()) {
				ans.append(stack.pop());
			}
			return ans.toString();
		}
	}
	
	private void dfs(MyNode node, Set<Character> processed, Set<Character> seen, Stack<Character> stack) {
		System.out.println("in dfs : " + node.c);
		System.out.println(stack);
		
		if(processed.contains(node.c)) {
			System.out.println("processed " + node.c);
			return;
		}
		
		if(seen.contains(node.c)) {
			System.out.println("++++++++++++++++++++++++ noAns ++++++++++++++++++++++++");
			noAns = true;
			return;
		}
		seen.add(node.c);
		
		node.next.forEach(n -> dfs(n, processed, seen, stack));
		
		stack.push(node.c);
		processed.add(node.c);
	}

	class MyNode {
		char c;
		List<MyNode> next;

		public MyNode(char c) {
			this.c = c;
			next = new ArrayList<>();
		}
		
		public void addNext(MyNode n) {
			next.add(n);
		}
	}
}
