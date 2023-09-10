package com.leetcode.test145.trie.maxXORinArray;

class Solution {
  public int findMaximumXOR (int[] nums) {
    Trie t = new Trie();
    for (int n : nums)
      t.insert(n);
    int max = Integer.MIN_VALUE;
    for (int n : nums)
      max = Math.max(max, t.findMaxXor(n));
    return max;
  }

  private static class Trie {
    Trie zero, one;

    void insert (int num) {
      Trie curr = this;
      for (int i = 31; i >= 0; i--) {
        if((num & (1 << i)) == 0) {
          if(curr.zero == null){
            curr.zero = new Trie();
          }
          curr = curr.zero;
        } else {
          if(curr.one == null){
            curr.one = new Trie();
          }
          curr = curr.one;
        }
      }
    }

    int findMaxXor (int num) {
      int ans = 0;
      Trie curr = this;
      for (int i = 31; i >= 0; i--) {
        if((num & (1 << i)) == 0) {
          if(curr.one != null) {
            ans += (1 << i);
            curr = curr.one;
          } else
            curr = curr.zero;
        } else {
          if(curr.zero != null) {
            ans += (1 << i);
            curr  = curr.zero;
          } else
            curr = curr.one;
        }
      }
      return ans;
    }
  }
}
