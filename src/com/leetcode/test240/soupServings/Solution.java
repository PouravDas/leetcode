package com.leetcode.test240.soupServings;

import java.util.HashMap;
import java.util.Map;

//808. Soup Servings
class Solution {
  public double soupServings (int n) {
    if(n > 4800) return 1;
    Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
    return soupServings(n, n, dp);
  }

  private double soupServings (int a, int b, Map<Integer, Map<Integer, Double>> dp) {
    if (dp.containsKey(a) && dp.get(a).containsKey(b))
      return dp.get(a).get(b);

    if (a <= 0 && b <= 0)
      return 0.5;
    else if (a <= 0)
      return 1;
    else if (b <= 0)
      return 0;

    double total = 0;
    total += 0.25 * soupServings(a - 100, b, dp);
    total += 0.25 * soupServings(a - 75, b - 25, dp);
    total += 0.25 * soupServings(a - 50, b - 50, dp);
    total += 0.25 * soupServings(a - 25, b - 75, dp);
    if (!dp.containsKey(a)) {
      dp.put(a, new HashMap<>());
    }
    dp.get(a).put(b, total);
    return total;
  }
}

