package com.leetcode.test91.wordBreak;

import java.util.List;

//wrong
public class SolutionTrie {

  public boolean wordBreak (String s, List<String> wordDict) {
    Trie t = new Trie();
    wordDict.forEach(t::insert);
    Boolean[] dp = new Boolean[s.length()];
    return t.find(s, 0,dp);
  }

  private static class Trie {

    private Trie[] children;
    private boolean isEndOfWord;

    public Trie () {
      children = new Trie[26];
    }

    public void insert (String word) {
      Trie curr = this;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new Trie();
        }
        curr = curr.children[c - 'a'];
      }
      curr.isEndOfWord = true;
    }

    public boolean find (String s, int i, Boolean[] dp) {
      if(i < dp.length && dp[i] != null) {
        return dp[i];
      }
      Trie curr = this;
      int I = i;
      while (i < s.length()) {
        char c = s.charAt(i);
        if (curr.children[c - 'a'] != null) {
          curr = curr.children[c - 'a'];
          i++;
          if (curr.isEndOfWord) {
            if (find(s, i,dp)) {
              return true;
            }
          }
        } else {
          break;
        }
      }
      if(i == s.length() && curr.isEndOfWord) {
        return dp[I] = true;
      }
      return dp[I] = false;
    }
  }

  public static void main (String[] args) {

  }
}
