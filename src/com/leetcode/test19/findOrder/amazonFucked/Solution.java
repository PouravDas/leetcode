package com.leetcode.test19.findOrder.amazonFucked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * wrong answer
 * @author pdas
 *
 */
public class Solution {

	public static void main(String[] args) {
		//String[] inputs = {"baa","abcd","abca","cab","cad"};
		String[] inputs = inputs_.split(" ");
		System.out.println(new Solution3().findOrder(inputs, 0, 0));
	}

	public String findOrder(String[] dict, int N, int K) {

		Map<Character, MyNode> map = new HashMap<>();
		Set<Character> heads = new HashSet<>();
		Set<Character> remove = new HashSet<>();
		for (int i = 0; i < dict.length - 1; i++) {
			String current = dict[i];
			String next = dict[i + 1];
			
			char start = '0';
			char end = '0';

			int l = Math.min(current.length(), next.length());

			int j = 0;
			
			for (; j < l; j++) {
				if(current.charAt(j) != next.charAt(j)) {
					start = current.charAt(j);
					end = next.charAt(j);
					break;
				}
			}
			
			if(start == '0') {
				if(j == current.length()) {
					start = next.charAt(j);
					end = start;
					while (end != start && j < next.length()) {
						end = next.charAt(++j);
					}
				}
			}
			
			if(start == end)
				continue;
			
			System.out.println(start + " -> " + end);
			Set<Character> all = new HashSet<>();
			all.addAll(remove);
			all.addAll(heads);
			System.out.println("all -> \n" + all);
			remove.add(end);
			heads.add(start);
			
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
			
			
			startNode.next = endNode;
		}
		heads.removeAll(remove);
		char h = '0';
		
		System.out.println(heads);
		if(heads.size() > 1)
			throw new RuntimeException("");
		
		for(char head: heads)
			h = head;
		
		StringBuilder ans = new StringBuilder() ;
		
		MyNode headNode = map.get(h);
		
		while(headNode != null) {
			ans.append(headNode.c);
			headNode = headNode.next;
		}
		
		return ans.toString();
	}

	class MyNode {
		char c;
		MyNode next;

		public MyNode(char c) {
			this.c = c;
		}

		public MyNode() {
		}
	}
	
	public static final String inputs_ = "bf biifablhhfekcjfhdklefkiihffedfjkklldcbfdldddbf bikjidjifidghfklddjchiebjbibdjadlgji bkblijbgjbkillhcblbjacadceahebbcafichcjedhbajlfkei bldgbfhkfdbcihbdkfejkdgikeclih cbielkdheejdicfjfeclbdliidkdcfifdgehlleikkdb cccfckhbglgfi cjjgibfkgegchldfaclliejhhcbjickadahbcdkialldfb eclbbfcjdfecfdkiblddaceclddfkaabjgalgiggacjdegf efdjhebdfebhhccahifhaififjbadhc eghcflfgkllde eidbdkcjicecjaiddfdcjkfj ejifhhdiclkkejdhidkhbhjdihbdkckfkgiidhadjdje elacahafeeghdgkic fag fbeidhlbfhcbjebaegidflileilejkijdfjdkiclabdfjeejeg gebfadchbgcikgkfifaga gialjghjjhhedflkkdjlhajdkhdakhadkkajgllgllbghk helekchjgeb iehdjcjefggkcafllgedfhjhhiahgc ike ikgjliklfblbagfafe ilfeajblklchcebejiggjhfbdcla jdlfbhdfjbdblgcceihcgiaachlhlhjhcglhcaf jeahcekiahlkidflijakdj jfhgbkchhgckahefbjcgaceibkiehallgiffddchacigefa jhlfhckghgkgfb kfcahfciklbakdgehkgfadggdcjcfaijkjlffjf kiidkhfcclldfceahaabjfgdi kjbchgcbbdghhk lfkdjkkeebibdidhjfkldkhecllebheehjhcaileeggafii lhd lkkkldcfbfekbjdfalhiddaiegkf lljjjgj";
}
