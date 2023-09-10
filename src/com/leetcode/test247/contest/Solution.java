package com.leetcode.test247.contest;

class Solution {
  public String finalString(String s) {
    String ans = "";
    for (char c : s.toCharArray()) {
      if(c == 'i') {
        ans = reverse(ans);
      } else {
        ans = ans + c;
      }
    }
    return ans;
  }

  private String reverse (String st) {
    int start = 0;
    int end = st.length() - 1;
    char[] ans = st.toCharArray();
    while (start < end) {
      char temp = ans[start];
      ans[start] = ans[end];
      ans[end] = temp;
      start++;
      end--;
    }
    return new String(ans);
  }
}
