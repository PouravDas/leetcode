package com.leetcode.test146.ciscoTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//cisco
class Result {

  /*
   * Complete the 'find_max_elements' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY array as parameter.
   */

  public static int find_max_elements (List<Integer> array) {
    int target = array.get(0);
    array.remove(0);
    int[] dp = new int[target + 1];
    int ans = findMax(array, 0, target, dp);
    return ans == Integer.MIN_VALUE ? 0 : ans;
  }

  private static int findMax (List<Integer> array, int idx, int target, int[] dp) {
    if (target == 0) {
      return 0;
    } else if (target < 0) {
      return Integer.MIN_VALUE;
    } else if (dp[target] != 0) {
      return dp[target];
    }

    int numbers = Integer.MIN_VALUE;
    for (int i = idx; i < array.size(); i++) {
      List<Integer> arrayNew = new ArrayList<>();
      arrayNew.addAll(array);
      arrayNew.remove(i);
      numbers = Math.max(numbers, findMax(arrayNew, idx, target - array.get(i), dp));
    }
    if (numbers == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    else
      return dp[target] = numbers + 1;
  }

  public static void main (String[] args) {
    find_max_elements(new ArrayList<>(List.of(10, 2, 3, 5, 5)));
    find_max_apples(2, new ArrayList<>(List.of(4, 2, 6, 100, 101, 101, 110, 102)));
  }

  public static int find_max_apples (int max_size_difference, List<Integer> apple_sizes) {
    Collections.sort(apple_sizes);
    int max = 0;
    int i = 0;
    int j = 0;
    while (j < apple_sizes.size()) {
      if (apple_sizes.get(j) - apple_sizes.get(i) <= max_size_difference) {
        j++;
      } else {
        while (apple_sizes.get(j) - apple_sizes.get(i) > max_size_difference) {
          i++;
        }
      }
      max = Math.max(max, j - i);
    }
    return max;
  }
}

