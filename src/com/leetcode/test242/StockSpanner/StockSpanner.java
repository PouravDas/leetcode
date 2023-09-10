package com.leetcode.test242.StockSpanner;

import java.util.ArrayDeque;

class StockSpanner {

  ArrayDeque<Entry> stack;

  public StockSpanner () {
    stack = new ArrayDeque<>();
  }

  public int next (int price) {
    Entry e = new Entry(price);
    while (!stack.isEmpty() && stack.peek().price <= price) {
      e.count += stack.pop().count;
    }
    stack.push(e);
    return stack.peek().count;
  }

  private static class Entry {
    int price;
    int count;

    Entry (int v) {
      price = v;
      count = 1;
    }
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
