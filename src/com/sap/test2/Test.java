package com.sap.test2;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {
  public static void main (String[] args) {
    Comparator<Person> comp = (a,b) -> {
      if(a.firstName.equals(b)) {
        return a.lastName.compareTo(b.lastName);
      }
      else return a.firstName.compareTo(b.firstName);
    };
    TreeSet<Person> set = new TreeSet<>(comp);
  }

  class Person {
    String firstName;
    String lastName;
  }
}
