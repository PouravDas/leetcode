package com.sentienz;

/*2 thread

1 -> 50

One thread will only print even no
Second thread will print only odd no

1 2 3 4 5..50
*/


public class Test {

  public static void main (String[] args) {
    Wrapper w = new Wrapper();
    EvenT evenT = new EvenT(w);
    OddT oddT = new OddT(w);
    evenT.start();
    oddT.start();
  }

  static class EvenT extends Thread {
    private Wrapper number;

    public EvenT (Wrapper n) {
      number = n;
    }

    @Override public void run () {
      synchronized (number) {
        while (number.num <= 50) {
          if (number.num % 2 == 0) {
            System.out.println("Even Thread " + number.num );
            number.num++;
          } else {
            try {
              number.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          number.notify();
        }
      }
    }
  }

  static class OddT extends Thread {
    private Wrapper number;

    public OddT (Wrapper n) {
      number = n;
    }

    @Override public void run () {
      synchronized (number) {
        while (number.num <= 50) {
          if (number.num % 2 != 0) {
            System.out.println("Odd Thread " + number.num);
            number.num++;
          } else {
            try {
              number.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          number.notify();
        }
      }
    }
  }

  static class Wrapper {
    int num;

    public Wrapper () {
      this.num = 1;
    }
  }
}
