package com.sentienz;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
producer and consumer and queue
 */
public class Test3 {

  public static void main (String[] args) {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    Producer p = new Producer(queue);
    Consumer c = new Consumer(queue);
    p.start();
    c.start();
  }

  static class Producer extends Thread {
    BlockingQueue<String> queue;

    public Producer (BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override public void run () {
      for (int i = 0; i < 10; i++) {
        queue.add("Record " + i);
      }
    }
  }


  static class Consumer extends Thread {
    BlockingQueue<String> queue;

    public Consumer (BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override public void run () {
      while (true) {
        if (!queue.isEmpty())
          System.out.println(queue.poll());
      }
    }
  }
}
