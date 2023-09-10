package com.leetcode.test32.ThreeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

  public List<List<Integer>> threeSum (int[] nums) {

    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {

      int j = i +1;
      int k = nums.length -1;
      
      while(j<k) {
        int a = nums[i];
        int b = nums[j];
        int c = nums[k];
        int sum = a + b +c;
        if(sum == 0) {
          set.add(List.of(a,b,c));
          j++;
          k--;
        } else if(sum < 0) {
          j++;
        } else {
          k--;
        }
      }
    }

    return List.copyOf(set);
  }

  public static void main (String[] args) {

    Solution s = new Solution();

    // [-1,0,1,2,-1,-4]
    // [7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15]
    List<List<Integer>> ans = s.threeSum(new int[] {-1,0,1,2,-1,-4});
    System.out.println(ans);
  }
  
  
}
