package com.cba.test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

  public static void main (String[] args) {
    List<Emp> list = null;
    Comparator c = null;
    Comparator c2 = null;
    Comparator c3 = c.thenComparing(c2);
    list.stream().collect(Collectors.groupingBy(Emp::getDep));
  }

  static class Emp {
    int id;
    String name;
    String dep;

    public String getDep () {
      return dep;
    }


  }
}
