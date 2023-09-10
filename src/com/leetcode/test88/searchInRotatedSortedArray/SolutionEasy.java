package com.leetcode.test88.searchInRotatedSortedArray;

public class SolutionEasy {
  public int search (int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + high;
      mid /= 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[low] <= nums[mid]) {
        // left is sorted
        if (target < nums[mid] && target >= nums[low]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // right is sorted
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

    }
    return -1;
  }

  public static void main (String[] args) {
    SolutionEasy s = new SolutionEasy();
    int ans = s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
    System.out.println(ans);
  }
}
