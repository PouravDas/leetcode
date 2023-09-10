package com.leetcode.test1;

import java.util.HashSet;

public class Amazon {

	public static void main(String[] args) {
		System.out.println("started");
		long start = System.currentTimeMillis();
		System.out.println(passwordStrength_(test1));
		long end = System.currentTimeMillis();
		System.out.println("time taken in mil sec : " + (end - start));
	}

	public static int passwordStrength_(String s) {
		int[] lastPosition = new int[26];

		int result = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			int last = lastPosition[c - 'A'];
			
			result += i + 1 + - last;
			
			
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


	public static int passwordStrength(String s) {

		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length() - i; j++) {
				ans += getUniqueChar(s.substring(j, j + i + 1));
			}
		}
		return ans;
	}

	public static int getUniqueChar(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(char c:s.toCharArray())
			set.add(c);
		return set.size();
	}

	private static final String test1 = "DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU";
}
