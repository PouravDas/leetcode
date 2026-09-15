package com.leetcode.test358.pratice.linklist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

  public Node reverse(Node head) {
    Node prev = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public Node reverse2(Node head) {
    return reverse2(null, head);
  }

  public Node reverse2(Node prev, Node head) {
    if (head == null) return prev;
    Node next = head.next;
    head.next = prev;
    prev = head;
    return reverse2(prev, next);
  }

  private static class Node {
    int num;
    Node next;
  }

  public int coinChange(int[] coins, int amount) {
    int ans = coinChange(coins, amount, new HashMap<>());
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  int coinChange(int[] coins, int amount, Map<Integer, Integer> dp) {
    if (amount == 0) return 0;
    if (amount < 0) return Integer.MAX_VALUE;
    if (dp.containsKey(amount)) return dp.get(amount);
    int ans = Integer.MAX_VALUE;
    for (int c : coins) {
      int cur = coinChange(coins, amount - c, dp);
      if (cur == Integer.MAX_VALUE) continue;
      if (cur < ans) ans = cur + 1;
    }
    dp.put(amount, ans);
    return ans;
  }


  public String longestPalindrome(String s) {
    String ans = "";
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j + i < s.length(); j++) {
        if (i == 0) {
          dp[j][j] = true;
        } else if (i == 1) {
          if (s.charAt(j) == s.charAt(j + i)) {
            dp[j][j + 1] = true;
          }
        } else {
          if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
            dp[j][j + i] = true;
          }
        }
        if (dp[j][j + i] && i + 1 > ans.length())
          ans = s.substring(j, j + i + 1);
      }
    }
    return ans;
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
        } else {
          dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
        }
      }
    }
    return dp[text1.length() - 1][text2.length() - 1];
  }

  public void sort012(int[] arr) {
    // code here
    int left = 0;
    int right = arr.length - 1;
    int run = 0;
    while (run <= right) {
      if(arr[run] == 0) {
        arr[run] = arr[left];
        arr[left] = 0;
        run++;
        left++;
      } else if(arr[run] == 2) {
        arr[run] = arr[right];
        arr[right] = 2;
        right--;
      } else {
        run++;
      }
    }
  }

  public int superEggDrop_(int k, int n) {
    int[][] dp = new int[k + 1][n + 1];
    return superEggDrop_(k, n, dp);
  }

  public int superEggDrop_(int k, int n, int[][] dp) {
    if (k == 0) return 0;
    if (n == 0) return 0;
    if (k == 1) return n;
    if (dp[k][n] != 0) return dp[k][n];
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int max = 1 + Math.max(superEggDrop_(k - 1, i - 1, dp), superEggDrop_(k, n - i, dp));
      min = Math.min(min, max);
    }
    return dp[k][n] = min;
  }


  public int superEggDrop(int eggs, int floors) {
    int[][] dp = new int[eggs + 1][floors + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp.length; j++) {
        if(i == 1) {
          dp[i][j] = j;
          continue;
        }
        int min = floors;
        for (int k = 1; k <= j; k++) {
          int eggBreaks = dp[i - 1][k - 1];
          int eggSurvives = dp[i][j - k];
          int max = Math.max(eggBreaks, eggSurvives);
          min = Math.min(min,max);
        }
        dp[i][j] = min;
      }
    }
    return dp[eggs][floors];
  }

  public int lengthOfLIS(int[] nums) {
    int[][] dp = new int[nums.length][nums.length + 1];
    return lengthOfLIS(nums, -1, 0, dp);
  }

  public int lengthOfLIS(int[] nums, int prevSel, int start, int[][] dp) {
    if (start == nums.length) return 0;
    if(dp[start][prevSel + 1] != 0) return dp[start][prevSel + 1];
    int select, notSelect;
    if (prevSel != -1) {
      while (start < nums.length && nums[start] <= nums[prevSel]) {
        start++;
      }
    }
    if (start == nums.length) return 0;
    select = 1 + lengthOfLIS(nums, start, start + 1, dp);
    notSelect = lengthOfLIS(nums, prevSel, start + 1, dp);
    return dp[start][prevSel + 1] = Math.max(select, notSelect);
  }

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i - 1; j >= 0; j--) {
        if(nums[i] > nums[j]) {
          max = Math.max(max, dp[j]);
        }
        dp[i] = 1 + max;
      }
      ans = Math.max(ans, max);
    }
    return ans;
  }

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return rob(nums, 0, dp);
  }

  public int rob(int[] nums, int start, int[] dp) {
    if (start >= nums.length) return 0;
    if (dp[start] != -1) return dp[start];
    int select = nums[start] + rob(nums, start + 2, dp);
    int notSelect = rob(nums, start + 1, dp);
    return dp[start] = Math.max(select, notSelect);
  }
}
