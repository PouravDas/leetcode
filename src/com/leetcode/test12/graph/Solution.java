package com.leetcode.test12.graph;

import java.util.HashMap;
import java.util.Map;

//133. Clone Graph
public class Solution {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n4);
		
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		
		n3.neighbors.add(n2);
		n3.neighbors.add(n4);
		
		n4.neighbors.add(n1);
		n4.neighbors.add(n3);

		Solution s = new Solution();
		Node clone = s.cloneGraph(new Node());
		System.out.println(clone);
	}

	Map<Integer,Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		Node clone = new Node();
		createClone(clone, node);
		return clone;
	}

	private void createClone(Node clone, Node org) {
		clone.val = org.val;
		map.put(clone.val, clone);

		System.out.print("[");
		for (Node node : org.neighbors) {
			System.out.print(node.val + ",");
		}
		System.out.print("]");
		System.out.println();
		
		for (Node node : org.neighbors) {
			Node nodeClone;
			if(!map.containsKey(node.val)) {
				nodeClone = new Node();
			} else 
				nodeClone = map.get(node.val);
				
			clone.neighbors.add(nodeClone);
			if (!map.containsKey(node.val))
				createClone(nodeClone, node);
		}
	}
}
