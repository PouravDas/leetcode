package com.leetcode.test267.fullJustify;

import java.util.ArrayList;
import java.util.List;

//68. Text Justification
//hard
class Solution {
  public List<String> fullJustify (String[] words, int maxWidth) {
    int idx = 0;
    List<String> list = new ArrayList<>();
    while (idx < words.length) {
      int startIdx = idx;
      int totalWordsLen = words[idx++].length();
      int noOfWord = 1;
      while (idx < words.length) {
        if (totalWordsLen + words[idx].length() + noOfWord <= maxWidth) {
          totalWordsLen += words[idx++].length();
          noOfWord++;
        } else {
          break;
        }
      }
      StringBuilder sb = new StringBuilder(maxWidth);
      if (idx == words.length) {
        for (int i = startIdx; i < words.length; i++) {
          sb.append(words[i]);
          if (i < words.length - 1) {
            sb.append(" ");
          }
        }
        while (sb.length() < maxWidth)
          sb.append(" ");
      } else {
        if (noOfWord == 1) {
          sb.append(words[startIdx]);
          while (sb.length() < maxWidth)
            sb.append(" ");
        } else {
          int spaces = (maxWidth - totalWordsLen) / (noOfWord - 1);
          int extras = (maxWidth - totalWordsLen) % (noOfWord - 1);
          for (int i = startIdx; i < startIdx + noOfWord; i++) {
            sb.append(words[i]);
            if (i < startIdx + noOfWord - 1) {
              for (int j = 0; j < spaces; j++) {
                sb.append(" ");
              }
              if (extras > 0) {
                sb.append(" ");
                extras--;
              }
            }
          }
        }
      }
      list.add(sb.toString());
    }
    return list;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.fullJustify(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
  }
}
