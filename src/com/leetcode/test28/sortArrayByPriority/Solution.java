package com.leetcode.test28.sortArrayByPriority;

class Solution {
  public int[] sortArrayByParity(int[] nums) {
      
      int ePt = 0;
      int oPt = nums.length -1;
      
      while(ePt < oPt) {
        if(isEven(nums[ePt])) {
          ePt ++;
        } else {
          if(isEven(nums[oPt])) {
            //swap
            int temp = nums[oPt];
            nums[oPt] = nums[ePt];
            nums[ePt] = temp;
            
            ePt++;
            oPt--;
          } else {
            oPt--;
          }
        }
      }
      return nums;
  }

  private boolean isEven (int i) {
    if(i == 0)
      return true;
    return i % 2 == 0;
  }
}
