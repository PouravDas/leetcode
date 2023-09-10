package com.leetcode.test32.ThreeSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<List<Integer>> threeSum (int[] nums) {

    Set<List<Integer>> theSet = new HashSet<>();
    List<Integer> trip = new ArrayList<>();

    findTrips(theSet, trip, nums, 0);

    final List<List<Integer>> toReturn = new ArrayList<>();
    theSet.forEach(s -> toReturn.add(new ArrayList<>(s)));

    return toReturn;
  }

  private void findTrips (Set<List<Integer>> theSet, List<Integer> trip, int[] nums, int i) {

    if (trip.size() == 3) {
      if (sum(trip) == 0) {
        trip.sort(Integer::compare);
        theSet.add(trip);
      }
      return;
    }

    if (i == nums.length) {
      return;
    }

    // exclude
    findTrips(theSet, trip, nums, i + 1);

    // include
    List<Integer> newTrip = new ArrayList<>(trip);
    newTrip.add(nums[i]);
    findTrips(theSet, newTrip, nums, i + 1);
  }

  private int sum (List<Integer> trip) {
    return trip.stream().mapToInt(Integer::intValue).sum();
  }

  public static void main (String[] args) {

    Solution s = new Solution();

    // [-1,0,1,2,-1,-4]
    // [7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15]
    List<List<Integer>> ans = s.threeSum(new int[] {7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15});
    System.out.println(ans);
  }
  
  
}
