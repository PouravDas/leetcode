package com.leetcode.test31.findTheClosestPalindrome;

class Solution {
  public String nearestPalindromic (String n) {

    boolean isEven = n.length() % 2 == 0;

    long num = Long.parseLong(n);

    if (num <= 10) {
      return "" + (num - 1);
    } else if (num == 11) {
      return "" + 9;
    } else if (num <= 17) {
      return "" + 11;
    }
    int mid = n.length() / 2;
    if (!isEven)
      mid++;

    String firstHalfStr = n.substring(0, mid);

    int firstHalf = Integer.parseInt(firstHalfStr);

    int firstHalfPre = firstHalf - 1;
    int firstHalfNex = firstHalf + 1;

    String firstHalfRev = reverse(firstHalf);
    String firstHalfPreRev = reverse(firstHalfPre);
    String firstHalfNexfRev = reverse(firstHalfNex);

    String pal1 = null;
    String pal2 = null;
    String pal3 = null;

    if (isEven) {
      pal2 = "" + firstHalf + firstHalfRev;
      if (countDigist(firstHalf) > countDigist(firstHalfPre))
        pal1 = "" + firstHalfPre + "9" + firstHalfPreRev;
      else
        pal1 = "" + firstHalfPre + firstHalfPreRev;

      if (countDigist(firstHalf) < countDigist(firstHalfNex))
        pal3 = "" + firstHalfNex + firstHalfNexfRev.substring(1);
      else
        pal3 = "" + firstHalfNex + firstHalfNexfRev;

    } else {
      pal2 = "" + firstHalf + firstHalfRev.substring(1);
      if (countDigist(firstHalf) > countDigist(firstHalfPre))
        pal1 = "" + firstHalfPre + firstHalfPreRev;
      else
        pal1 = "" + firstHalfPre + firstHalfPreRev.substring(1);
      if (countDigist(firstHalf) < countDigist(firstHalfNex))
        pal3 = ("" + firstHalfNex).substring(0, ("" + firstHalfNex).length() - 1)
            + firstHalfNexfRev.substring(1);
      else
        pal3 = "" + firstHalfNex + firstHalfNexfRev.substring(1);
    }

    long palNum1 = Long.parseLong(pal1);
    long palNum2 = Long.parseLong(pal2);
    long palNum3 = Long.parseLong(pal3);

    if (palNum2 == num) {
      if (Math.abs(palNum1 - num) <= Math.abs(palNum3 - num))
        return pal1;
      else
        return pal3;
    } else if (palNum1 <= num && num <= palNum2) {
      if (Math.abs(palNum1 - num) <= Math.abs(palNum2 - num)) {
        return pal1;
      } else {
        return pal2;
      }
    } else {
      if (Math.abs(palNum2 - num) <= Math.abs(palNum3 - num)) {
        return pal2;
      } else {
        return pal3;
      }
    }
  }

  private String reverse (int num) {
    StringBuilder ans = new StringBuilder(countDigist(num));
    while (num > 0) {
      ans.append(num % 10);
      num /= 10;
    }
    return ans.toString();
  }

  private int countDigist (int theAns) {
    int digits = 0;
    while (theAns > 0) {
      theAns /= 10;
      digits++;
    }
    return digits;
  }

  public static void main (String[] args) {

    Solution s = new Solution();

    System.out.println(s.nearestPalindromic("99"));
  }
}
