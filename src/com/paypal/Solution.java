package com.paypal;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

interface IBookingService {
  boolean startBookingProcess(int eventId, int userId);

  BookingConclusion confirmBookingStatus(int evenId, int userId, boolean bookingSuccessful);
}

interface IRepo {
  void registerEventInAuditorium(int auditoriumNumber, int eventId, int capacity);

  Auditorium getAuditoriumDetailsForEvent(int evenId);

  int getNumberOfSeatsBooksOrUnderBookingForEvent(int eventId);

  void addUnderBooking(int eventId, int userId);

  void removeUnderBooking(int eventId, int userId);

  void addSuccessfulBooking(int eventId, int userId);
}

class BookingConclusion {
  boolean isSuccessful;
  int auditoriumNumber;
}

class Auditorium {
  int auditoriumNumber;
  int eventId;
  int capacity;
  int totalSeatsBooked;
  Set<Integer> userIdUnderBooking = new HashSet<>();
  Set<Integer> userIdUnderConfirmed = new HashSet<>();
}

class BookingService implements IBookingService {
  public IRepo repo;

  public BookingService(IRepo repo) {
    this.repo = repo;
  }

  @Override
  public boolean startBookingProcess(int eventId, int userId) {
    try {
      repo.addUnderBooking(eventId, userId);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public BookingConclusion confirmBookingStatus(int eventId, int userId, boolean bookingSuccessful) {
    Auditorium auditorium = repo.getAuditoriumDetailsForEvent(eventId);
    boolean status = auditorium.userIdUnderConfirmed.contains(userId);
    BookingConclusion conclusion = new BookingConclusion();
    conclusion.isSuccessful = status;
    conclusion.auditoriumNumber = auditorium.auditoriumNumber;
    return conclusion;
  }
}

class Repo implements IRepo {

  private Map<Integer, Auditorium> eventId2Aud = new ConcurrentHashMap<>();

  @Override
  public void registerEventInAuditorium(int auditoriumNumber, int evenId, int capacity) {
    Auditorium auditorium = new Auditorium();
    auditorium.auditoriumNumber = auditoriumNumber;
    auditorium.eventId = evenId;
    auditorium.capacity = capacity;
    eventId2Aud.put(evenId, auditorium);
  }

  @Override
  public int getNumberOfSeatsBooksOrUnderBookingForEvent(int eventId) {
    Auditorium auditorium = eventId2Aud.get(eventId);
    return auditorium.totalSeatsBooked;
  }

  @Override
  public void addUnderBooking(int eventId, int userId) {
    Auditorium auditorium = eventId2Aud.get(eventId);
    synchronized (auditorium) {
      if (auditorium.totalSeatsBooked < auditorium.capacity) {
        auditorium.totalSeatsBooked++;
        auditorium.userIdUnderBooking.add(userId);
        System.out.print("aud : " + auditorium.auditoriumNumber + " totatSet : " + auditorium.totalSeatsBooked);
      } else {
        System.out.print("throwing");
        throw new RuntimeException("no seats");
      }
    }

  }

  @Override
  public void removeUnderBooking(int eventId, int userId) {
    Auditorium auditorium = eventId2Aud.get(eventId);
    synchronized (auditorium) {
      if (auditorium.userIdUnderBooking.contains(userId)) {
        auditorium.totalSeatsBooked--;
        auditorium.userIdUnderBooking.remove(userId);
      }
    }
  }

  @Override
  public void addSuccessfulBooking(int eventId, int userId) {
    Auditorium auditorium = eventId2Aud.get(eventId);
    synchronized (auditorium) {
      if (auditorium.userIdUnderBooking.contains(userId)) {
        auditorium.userIdUnderConfirmed.add(userId);
        auditorium.userIdUnderBooking.remove(userId);
      } else {
        throw new RuntimeException("no seats");
      }
    }
  }

  @Override
  public Auditorium getAuditoriumDetailsForEvent(int eventId) {
    return eventId2Aud.get(eventId);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    String inp[];
    int totalNumberOfAuditoriums = Integer.parseInt(br.readLine().trim());
    int capacityOfAuditorium[] = new int[totalNumberOfAuditoriums];
    int evenIdInAuditorum[] = new int[totalNumberOfAuditoriums];

    inp = br.readLine().split(" ");
    for (int i = 0; i < totalNumberOfAuditoriums; i++) {
      evenIdInAuditorum[i] = Integer.parseInt(inp[i]);
    }
    inp = br.readLine().split(" ");
    for (int i = 0; i < totalNumberOfAuditoriums; i++) {
      capacityOfAuditorium[i] = Integer.parseInt(inp[i]);
    }
    IRepo repo = new Repo();
    for (int i = 0; i < totalNumberOfAuditoriums; i++) {
      repo.registerEventInAuditorium(i, evenIdInAuditorum[i], capacityOfAuditorium[i]);
    }
    IBookingService bookingService = new BookingService(repo);
    int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());
    for (int requestNumber = 1; requestNumber <= totalNumberOfRequests; requestNumber++) {
      inp = br.readLine().split(" ");
      String query = inp[0];
      int evenId, userId;
      switch (query) {
        case "startBookingProcess":
          evenId = Integer.parseInt(inp[1]);
          userId = Integer.parseInt(inp[2]);
          boolean didStartBookingProcess = bookingService.startBookingProcess(evenId, userId);
          out.println(didStartBookingProcess);
          break;
        case "confirmBookingStatus":
          evenId = Integer.parseInt(inp[1]);
          userId = Integer.parseInt(inp[2]);
          boolean isSuccessfulBooking = Boolean.parseBoolean(inp[3]);
          BookingConclusion bookingConclusion = bookingService.confirmBookingStatus(evenId, userId, isSuccessfulBooking);
          out.println((bookingConclusion.isSuccessful ? "successful" : "failed") + " " + bookingConclusion.auditoriumNumber);
          break;
      }
    }

    out.flush();
    out.close();
  }
}
