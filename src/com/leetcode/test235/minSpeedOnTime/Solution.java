package com.leetcode.test235.minSpeedOnTime;

class Solution {
  public int minSpeedOnTime (int[] dist, double hour) {
    int totalDistance = 0;
    int max = 0;
    for (int d : dist) {
      totalDistance += d;
    }
    int start = (int) (totalDistance / hour);
    int end = Integer.MAX_VALUE;
    while (start <= end) {
      int mid = end + start;
      mid /= 2;
      double midTime = timeTaken(mid, dist);
      double nextTime = timeTaken(mid - 1, dist);
      if(midTime <= hour && nextTime > hour)
        return mid;
      else if(midTime > hour) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  private double timeTaken (int mid, int[] dist) {
    double time = 0;
    for (int i = 0; i < dist.length; i++) {
      time += dist[i] * 1.0 / mid;
      if(i != dist.length - 1){
        time = Math.ceil(time);
      }
    }
    return time;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minSpeedOnTime(new int[]{1,3,2},6.0);
  }
}
