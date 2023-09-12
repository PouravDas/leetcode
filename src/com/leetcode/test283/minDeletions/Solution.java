package com.leetcode.test283.minDeletions;

//1647. Minimum Deletions to Make Character Frequencies Unique
class Solution {
  public int minDeletions (String s) {
    int deletes = 0;
    int[] counts = new int[26];
    for (char c : s.toCharArray())
      counts[c - 'a']++;
    for (int i = 0; i < 26; i++) {
      if (counts[i] == 0)
        continue;
      int c = counts[i];
      boolean found = true;
      while (found && c > 0) {
        found = false;
        for (int j = 0; j < 26; j++) {
          if(j == i) continue;
          if(counts[j] == c) {
            found = true;
            c--;
            break;
          }
        }
      }
      deletes += counts[i] - c;
      counts[i] = c;
    }
    return deletes;
  }
}
