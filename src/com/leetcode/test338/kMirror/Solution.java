package com.leetcode.test338.kMirror;

import java.util.ArrayList;
import java.util.List;

//
public class Solution {
  long ans = 0;
  int count;

  public long kMirror(int k, int n) {
    List<Long> base10List = new ArrayList<>();
    generatePalNumb(base10List, 0, 0, k, n);
    return ans;
  }

  private void generatePalNumb(List<Long> base10List, int idx, int len, int k, int n) {
    int size = base10List.size();
    if (len == 0) {
      for (long i = 1; i < 10; i++) {
        base10List.add(i);
        if (isKBasePal(i, k)) {
          count++;
          ans += i;
          if (count == n) return;
        }
      }
    } else if ((len & 1) == 0) { // even
      // 0 - 9 insert in mid

      for (int i = idx; i < size; i++) {
        for (int j = 0; j < 10; j++) {
          String s = "" + base10List.get(i);
          String newS = s.substring(0, s.length() >> 1) + j + s.substring(s.length() >> 1);
          var in = Long.parseLong(newS);
          base10List.add(in);
          if (isKBasePal(in, k)) {
            count++;
            ans += in;
            if (count == n) return;
          }
        }
      }
    } else {
      // copy and add mid to mid+1
      for (int i = idx; i < size; i++) {
        String s = "" + base10List.get(i);
        String newS = s.substring(0, (s.length() >> 1) + 1) + s.charAt(s.length() >> 1) + s.substring((s.length() >> 1) + 1);
        var in = Long.parseLong(newS);
        base10List.add(in);
        if (isKBasePal(in, k)) {
          count++;
          ans += in;
          if (count == n) return;
        }
      }
    }
    generatePalNumb(base10List, size, len + 1, k, n);
  }

  private boolean isKBasePal(long i, int base) {
    String num = "";
    while (i > 0) {
      num = i % base + num;
      i = i / base;
    }
    int l = 0;
    int r = num.length() - 1;
    while (l < r) {
      if (num.charAt(l++) != num.charAt(r--)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.kMirror(2, 1);
  }
}
