package com.sentienz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Int[] a = [38, 47,10, -20, 65, 72]
{72, 47} { 38, 10, -20, 65}

1 ,2, 5, 8,

8, 1


sum 16 8,
 */
public class Test2 {

  public static void main (String[] args) {
    List<Emp> list = new ArrayList<>();
    list.stream().sorted((e1,e2) -> e2.salary - e1.salary).collect(Collectors.toList());
    list.stream().collect(Collectors.groupingBy(emp -> emp.dp));
  }

  static class Emp {
    int id, salary;
    String name, dp;
  }
}
