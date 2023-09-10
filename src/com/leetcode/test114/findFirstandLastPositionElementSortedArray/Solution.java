package com.leetcode.test114.findFirstandLastPositionElementSortedArray;

class Solution {
  public int[] searchRange (int[] nums, int target) {
    int[] res = new int[2];
    int start = 0;
    int end = nums.length - 1;
    int mid = start + end;
    mid /= 2;
    boolean found = false;
    while (start <= end) {
      if (nums[mid] == target) {
        found = true;
        break;
      }
      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      mid = start + end;
      mid /= 2;
    }
    if (found) {
      int left = mid;
      int right = mid;
      while (found) {
        start = 0;
        end = mid - 1;
        found = false;
        mid = start + end;
        mid /= 2;
        while (start <= end) {
          if (nums[mid] == target) {
            found = true;
            left = mid;
            break;
          }
          if (nums[mid] < target) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
          mid = start + end;
          mid /= 2;
        }
      }
      found = true;
      mid = right;
      while (found) {
        start = mid + 1;
        end = nums.length - 1;
        found = false;
        mid = start + end;
        mid /= 2;
        while (start <= end) {
          if (nums[mid] == target) {
            found = true;
            right = mid;
            break;
          }
          if (nums[mid] < target) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
          mid = start + end;
          mid /= 2;
        }
      }
      res[0] = left;
      res[1] = right;
    } else {
      res[0] = res[1] = -1;
    }
    return res;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[] ans = s.searchRange(new int[] {1}, 1);
    System.out.println();
  }
}
