package com.leetcode.test64.findUniqueBinaryString;

//#1980
public class Solution {

  public String findDifferentBinaryString(String[] nums) {

    boolean[] present = new boolean[(int) Math.pow(2, nums.length)];

    for (String n :nums){
      present[binaryToNum(n)] = true;
    }

    for(int i = 0; i < present.length;i++){
      if(!present[i]){
        String ans = "";
        for(int j = nums.length -1; j>=0; j--){
          if((i&(1<<j)) == 0){
            ans += "0";
          }else {
            ans += "1";
          }
        }
        return ans;
      }
    }

    return null;
  }

  private int binaryToNum(String st){
    int ans = 0;

    for(int i = 0; i< st.length(); i++){
      char bit = st.charAt(st.length() - 1 - i);
      ans += bit == '1' ? Math.pow(2, i) : 0;
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findDifferentBinaryString(new String []{"01","10"});
  }
}
