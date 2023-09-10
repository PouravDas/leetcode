package com.leetcode.test256.findPrimePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> findPrimePairs (int n) {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] isPrime = isPrime(n);
    for (int i = 2; i <= n / 2; i++) {
      if (isPrime[i] && isPrime[n - i])
        list.add(List.of(i, n - i));
    }
    return list;
  }

  boolean[] isPrime (int n) {
    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);
    primes[0] = primes[1] = false;
    for (int i = 2; i * i <= n; i++) {
      for (int j = i * 2; j <= n; j += i) {
        primes[j] = false;
      }
    }
    return primes;
  }
}
