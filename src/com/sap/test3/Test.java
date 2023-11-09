package com.sap.test3;

import java.util.Map;

public class Test {
  public static void main (String[] args) {
    Thread t1 = new Thread(()->{
      System.out.println("thread 1");
    });
    t1.start();

    Thread t2 = new Thread() {
      @Override public void run () {
        System.out.println("thread 2");
      }
    };

  }


  class Emp {

    private final int id;
    private final String name;
    private final Map<String,String> map;

    Emp (int id, String name, Map<String,String> map) {
      this.id = id;
      this.name = name;
      this.map = map;
    }

    public int getId () {
      return id;
    }

    public Map<String, String> getMap () {

      return map;
    }

    public String getName () {
      return name;
    }
  }
}
