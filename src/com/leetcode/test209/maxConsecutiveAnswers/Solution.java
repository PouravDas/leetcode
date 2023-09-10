package com.leetcode.test209.maxConsecutiveAnswers;

class Solution {
  public int maxConsecutiveAnswers(String answerKey, int k) {
    int max = 0;
    int left = 0, right = 0;
    int size = 0;
    int flips = 0;
    //flip F
    while(right < answerKey.length()) {
      if(answerKey.charAt(right++) == 'T') {
        size++;
      } else {
        flips++;
        size++;
        if(flips > k) {
          while(left < answerKey.length() && flips > k) {
            if (answerKey.charAt(left++) != 'T') {
              flips--;
            }
            size--;
          }
        }
      }
      max = Math.max(max,size);
    }
    //flip T
    left = 0; right = 0;  size = 0; flips = 0;
    while(right < answerKey.length()) {
      if(answerKey.charAt(right++) == 'F') {
        size++;
      } else {
        flips++;
        if(flips > k) {
          while(left < answerKey.length() && flips > k) {
            if (answerKey.charAt(left++) != 'F') {
              flips--;
            }
            size--;
          }
        }
      }
      max = Math.max(max,size);
    }
    return max;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.maxConsecutiveAnswers("TTFF" , 2);
  }
}
