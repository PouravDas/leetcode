package com.leetcode.test342.mostBooked;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int mostBooked(int n, int[][] meetings) {

    PriorityQueue<MeetingRoom> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.offer(new MeetingRoom(i));
    }
    Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
    for(int[] m : meetings) {
      MeetingRoom meetingRoom = pq.poll();
      meetingRoom.noOfMeets++;
      meetingRoom.freeAt = Math.max(meetingRoom.freeAt + m[1] - m[0], m[1]);
      pq.offer(meetingRoom);
    }
    return pq.stream().max(Comparator.comparingInt((MeetingRoom m) -> m.noOfMeets).thenComparingInt(m -> -m.roomNo)).map(m -> m.roomNo).get();
  }

  private static class MeetingRoom implements Comparable<MeetingRoom> {
    int roomNo;
    int freeAt;
    int noOfMeets;

    MeetingRoom(int roomNo) {
      this.roomNo = roomNo;
      this.noOfMeets = 0;
      this.freeAt = 0;
    }

    @Override
    public int compareTo(MeetingRoom o) {
      return this.freeAt - o.freeAt == 0 ? this.roomNo - o.roomNo : this.freeAt - o.freeAt;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //int ans = s.mostBooked(2, new int[][]{{0,10},{1,5},{2,7},{3,4}});[[18,19],[3,12],[17,19],[2,13],[7,10]]
    int ans = s.mostBooked(4, new int[][]{{18,19},{3,12},{17,19},{2,13},{7,10}});
    System.out.println(ans);
  }
}
