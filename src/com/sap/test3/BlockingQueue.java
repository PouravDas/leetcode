package com.sap.test3;

// size limit
// producer waits if the size is reached
// consumer will wait if there are no data to pull

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue<T> {

  private Queue<T> queue;
  private final int size;

  public BlockingQueue (int s) {
    size = s;
    queue = new ArrayDeque<>();
  }

  public void push(T data) {
      synchronized (queue) {
        try {
          if(queue.size() < size) {
            queue.offer(data);
          } else {
            queue.wait();
          }
          queue.notify();
        } catch (Exception e) {

        }
      }
  }

  public T poll () {
    synchronized (queue) {
      if(queue.isEmpty()) {
        try {
          queue.wait();
          return queue.poll();
        } catch (Exception e) {
          return null;
        }
      } else {
        return queue.poll();
      }
    }
  }
}
