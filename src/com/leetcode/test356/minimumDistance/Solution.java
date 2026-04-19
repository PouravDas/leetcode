package com.leetcode.test356.minimumDistance;

import java.util.HashMap;
import java.util.Map;

//1320. Minimum Distance to Type a Word Using Two Fingers
public class Solution {
  int[][] keyboard = new int[26][];

  {
    int c = 0;
    int i = 0;
    while (c < 26) {
      for (int j = 0; j < 6 && c < 26; j++) {
        keyboard[c++] = new int[]{i, j};
      }
      i++;
    }
  }

  public int minimumDistance(String word) {
    Map<String, Integer> dp = new HashMap<>();
    return find(keyboard[word.charAt(0) - 'A'], null, 1, word, dp);
  }

  private int find(int[] finger1, int[] finger2, int i, String word, Map<String, Integer> dp) {
    if (i >= word.length()) return 0;
    int[] curKey = keyboard[word.charAt(i) - 'A'];

    String stringCode = getString(finger1, finger2, i);
    //if (dp.containsKey(stringCode)) return dp.get(stringCode);

    int disFing1 = distance(finger1, curKey);
    int ans;
    if (finger2 == null) {
      //assign and check
      int option1 = find(finger1, curKey, i + 1, word, dp);
      //use finger1 and check
      int option2 = disFing1 + find(curKey, null, i + 1, word, dp);
      ans = Math.min(option1, option2);
    } else {
      int disFing2 = distance(finger2, curKey);
      int option1 = disFing1 + find(curKey, finger2, i + 1, word, dp);
      int option2 = disFing2 + find(finger1, curKey, i + 1, word, dp);
      ans = Math.min(option1, option2);
    }

    //dp.put(stringCode, ans);
    return ans;
  }

  private String getString(int[] finger1, int[] finger2, int i) {
    StringBuilder sb = new StringBuilder();
    sb.append(finger1[0]).append(',').append(finger1[1]);
    if (finger2 != null) {
      sb.append('#').append(finger2[0]).append(',').append(finger2[1]);
    }
    sb.append('#').append(i);
    return sb.toString();
  }

  int distance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //var ans = s.minimumDistance("CAKE");
    var ans =s.minimumDistance("OPVUWZLCKTDPSUKGHAXIDWHLZFKNBDZEWHBSURTVCADUGTSDMCLDBTAGFWDPGXZBVARNTDICHCUJLNFBQOBTDWMGILXPSFWVGYBZVFFKQIDTOVFAPVNSQJULMVIERWAOXCKXBRI");
    System.out.println(ans);
  }
}
