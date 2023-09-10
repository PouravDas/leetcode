package com.leetcode.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		System.out.println("started");
		long start = System.currentTimeMillis();
		System.out.println(uniqueLetterString("ABCDCEFC"));
		long end = System.currentTimeMillis();
		System.out.println("time taken in mil sec : " + (end - start));
	}

	public static int uniqueLetterString3(String s) {
		int[] lastPosition = new int[26];
		int[] previousPosition = new int[26];

		int result = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			int last = lastPosition[c - 'A'];
			
			int previous = previousPosition[c - 'A'];
			result += i + 1 -2 * last - 2*previous;
			
			
			previousPosition[c - 'A'] = lastPosition[c - 'A'];
			lastPosition[c - 'A'] = i + 1;
			
			
			count += result;
			
			
			
			/*

			char c = s.charAt(i);
			int last = lastPosition[c - 'A'];
			result += (i - last + 1);
			int previous = previousPosition[c - 'A'];
			result -= (last - previous);
			previousPosition[c - 'A'] = lastPosition[c - 'A'];
			lastPosition[c - 'A'] = i + 1;
			count += result;
			*/
		}

		return count;
	}

	public static int uniqueLetterString2(String s) {
		int ans = 0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			ans++;
			for (int j = 0; j < list.size(); j++) {
				String update = list.get(j) + s.charAt(i);
				list.set(j, update);
				ans += getUniqueChar(update);
			}
			list.add("" + s.charAt(i));
		}

		return ans;
	}

	public static int uniqueLetterString(String s) {

		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length() - i; j++) {
				ans += getUniqueChar(s.substring(j, j + i + 1));
			}
		}
		return ans;
	}

	public static int getUniqueChar(String s) {
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else
				map.put(s.charAt(i), 0);
		}
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() == 0) {
				ans++;
			}
		}
		return ans;
	}

	private static final String test1 = "DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU";
}
