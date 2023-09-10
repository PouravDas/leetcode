package com.leetcode.test26.stepToMakeArrayNonDecrease;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;


public class Solution {


  public int totalSteps__wrong (int[] nums) {

    int[] dp = new int[nums.length];

    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        dp[i] = 0;
      }

      else if (nums[i] < nums[i - 1]) {
        dp[i] = 1;
      }

      else if (dp[i - 1] > 0) {
        int maxToGo = dp[i - 1];
        int toGo = i - 1 - dp[i - 1];
        while (dp[toGo] > 0) {
          maxToGo = Math.max(maxToGo, dp[toGo]);
          toGo = toGo - dp[toGo];
        }
        if (nums[i] < nums[toGo]) {
          dp[i] = maxToGo + 1;
        }
      }

      result = Math.max(result, dp[i]);
    }
    return result;
  }



  public int totalSteps (int[] nums) {

    Stack<Pair<Integer, Integer>> stack = new Stack<>();

    for (int i = nums.length - 1; i > -1; i--) {
      if (stack.isEmpty()) {
        stack.push(new Pair<Integer, Integer>(nums[i], 0));
      } else if (stack.peek().fst >= nums[i]) {
        stack.push(new Pair<Integer, Integer>(nums[i], 0));
      } else {
        int result = 0;
        while (!stack.isEmpty() && nums[i] > stack.peek().fst) {
          result++;
          Pair<Integer, Integer> p = stack.pop();
          result = Math.max(result, p.snd);
        }
        stack.push(new Pair<Integer, Integer>(nums[i], result));
      }
    }

    final AtomicInteger r = new AtomicInteger(0);
    stack.forEach(p -> r.set(Math.max(r.get(), p.snd)));
    return r.get();
  }

  private class Pair<A, B> {

    public final A fst;
    public final B snd;

    public Pair(A fst, B snd) {
      this.fst = fst;
      this.snd = snd;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    // [10,1,2,3,4,5,6,1,2,3]
    // 5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11
    // [7,14,4,14,13,2,6,13]
    // [5,14,15,2,11,5,13,15]
    int[] nums = new int[] {5, 14, 15, 2, 11, 5, 13, 15};
    int ans = s.totalSteps(nums);
    System.out.println(ans);
  }
}
