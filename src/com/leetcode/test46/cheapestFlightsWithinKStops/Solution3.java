package com.leetcode.test46.cheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3 {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<Flight>> map = new HashMap<>();
    for (int[] f : flights) {
      List<Flight> connectedFlights = map.getOrDefault(f[0], new ArrayList<>());
      connectedFlights.add(new Flight(f[0], f[1], f[2]));
      map.put(f[0], connectedFlights);
    }
    PriorityQueue<FlightCost> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(f -> f.totalCost));
    List<Flight> flightList = map.getOrDefault(src, List.of());
    for (Flight f : flightList) {
      priorityQueue.add(new FlightCost(0, f.cost, f));
    }
    while (!priorityQueue.isEmpty()) {
      FlightCost f = priorityQueue.poll();
      if (f.stops > k) continue;
      if (f.flight.des == dst) return f.totalCost;

      List<Flight> nextFlights = map.get(f.flight.des);
      for (Flight nextFlight : nextFlights) {
        priorityQueue.add(new FlightCost(f.stops + 1, f.totalCost + nextFlight.cost, nextFlight));
      }
    }
    return -1;
  }

  private static class Flight {
    int src;
    int des;
    int cost;

    public Flight(int src, int des, int cost) {
      this.cost = cost;
      this.des = des;
      this.src = src;
    }
  }

  private static class FlightCost {
    Flight flight;
    int totalCost;
    int stops;

    public FlightCost(int stops, int totalCost, Flight flight) {
      this.stops = stops;
      this.totalCost = totalCost;
      this.flight = flight;
    }
  }
}
