package com.leetcode.test29.findPalindromeWithFixedLength;

public class Solution {
  public long[] kthPalindrome (int[] queries, int intLength) {
    long[] ans = new long[queries.length];

    long firstHalfLen = intLength % 2 == 0 ? intLength / 2 : (intLength + 1) / 2;

    long firstNum = getFirstNum(firstHalfLen);

    for (int i = 0; i < queries.length; i++) {
      int pos = queries[i];

      long theAns = firstNum + pos - 1;

      if (countDigist(theAns) > firstHalfLen) {
        ans[i] = -1;
      } else {
        ans[i] = getPal(theAns, intLength);
      }

    }

    return ans;
  }

  private long getFirstNum (long l) {
    long ans = 1;
    for(long i = 1; i < l; i++)
      ans *= 10;
    return ans;
  }

  private long getPal (long theAns, int intLength) {
    if (intLength == 1) {
      return theAns;
    }

    long ans = theAns;
    if (intLength % 2 == 1) {
      theAns /= 10;
    }

    while (theAns > 0) {
      ans = ans * 10 + (theAns % 10);
      theAns /= 10;
    }

    return ans;
  }

  private long countDigist (long theAns) {
    long digits = 0;
    while (theAns > 0) {
      theAns /= 10;
      digits++;
    }
    return digits;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //s.kthPalindrome(new int[] {1, 2, 3, 4, 5, 90}, 3);
    
    s.kthPalindrome(new int[] {2,201429812,8,520498110,492711727,339882032,462074369,9,7,6}, 1);
  }
}

// [1,2,3,4,5,90] ,3 

// [2,201429812,8,520498110,492711727,339882032,462074369,9,7,6] , 1
