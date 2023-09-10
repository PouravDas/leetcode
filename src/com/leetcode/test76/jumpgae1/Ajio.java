package com.leetcode.test76.jumpgae1;

import java.util.Stack;

public class Ajio {

  public static void main (String[] args) {
    Node head = new Node('I', new Node(' ', new Node('a',
        new Node('m', new Node(' ', new Node('b', new Node('a', new Node('d', null))))))));

    printList(head);

    Node rev = reverse(head);

    printList(rev);
  }

  private static void printList (Node head) {
    System.out.println();
    while(head != null){
      System.out.print(head.c);
      head = head.next;
    }
    System.out.println();
  }

  public static Node reverse (Node head) {

    Node temp = null;
    Stack<Node> stack = new Stack<>();

    while (head != null) {
      Node next = null;
      stack.push(head);

      while (head.next != null && head.c != ' ') {
        head = head.next;
      }

      next = head.next;
      head.next = null;
      head = next;
    }

    Node toReturn = stack.peek();
    Node n = null;

    while (!stack.isEmpty()) {
      Node ele = stack.pop();
      if (n != null) {
        n.next = ele;
      } else {
        n = ele;
      }

      while (n.next != null) {
        n = n.next;
      }

      if (n.c != ' ') {
        Node space = new Node();
        space.c = ' ';
        n.next = space;
        n = n.next;
      }
    }
    return toReturn;
  }

  private static class Node {
    char c;
    Node next;

    Node () {
    }

    Node (char c, Node n) {
      this.c = c;
      next = n;
    }
  }
}
