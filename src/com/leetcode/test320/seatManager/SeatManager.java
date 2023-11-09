package com.leetcode.test320.seatManager;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//1845. Seat Reservation Manager
class SeatManager {

  Queue<Integer> unreserved;
  Set<Integer> reserved;

  public SeatManager(int n) {
    unreserved = new PriorityQueue<>(n);
    reserved = new HashSet<>(n);
    for (int i = 1; i <= n; i++) {
      unreserved.offer(i);
    }
  }

  public int reserve() {
    int toReserve = unreserved.poll();
    reserved.add(toReserve);
    return toReserve;
  }

  public void unreserve(int seatNumber) {
    reserved.remove(seatNumber);
    unreserved.offer(seatNumber);
  }
}
