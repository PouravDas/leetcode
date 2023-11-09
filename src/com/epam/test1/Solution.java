package com.epam.test1;

class Solution {
  public String solution(int N) {
    StringBuilder sb = new StringBuilder(N);
    if((N & 1) == 0) {
      //even
      for (int i = 0; i < N - 1; i++) {
        sb.append('x');
      }
      sb.append('y');
    } else {
      for (int i = 0; i < N; i++) {
        sb.append('x');
      }
    }
    return sb.toString();
  }
}

