package com.leetcode.test89.SwapAdjacentInLRString;

// # 777
class Solution {
  public boolean canTransform (String s, String e) {

    char[] start = s.toCharArray();
    char[] end = e.toCharArray();
    for (int i = 0; i < start.length; i++) {
      if (start[i] == end[i])
        continue;
      else if (i == start.length - 1) {
        return false;
      } else {
        char cur = start[i];
        char tar = end[i];
        if (cur == 'X') {
          if (tar == 'L') {
            int j = i + 1;
            boolean found = false;
            while (j < start.length) {
              if (tar == start[j]) {
                found = true;
                break;
              } else if(start[j] == 'X'){
                j++;
              } else {
                return false;
              }
            }
            if (found) {
              char temp = start[i];
              start[i] = start[j];
              start[j] = temp;
            } else {
              return false;
            }
          } else {
            return false;
          }
        } else if (cur == 'L') {
          return false;
        } else { // R
          if (tar == 'X') {
            int j = i + 1;
            boolean found = false;
            while (j < start.length) {
              if (tar == start[j]) {
                found = true;
                break;
              } else if(start[j] == 'R') {
                j++;
              } else {
                return false;
              }
            }
            if (found) {
              char temp = start[i];
              start[i] = start[j];
              start[j] = temp;
            } else {
              return false;
            }
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    boolean ans = s.canTransform("RLX", "XLR");
    System.out.println(ans);
  }
}
