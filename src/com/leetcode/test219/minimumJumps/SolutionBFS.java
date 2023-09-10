package com.leetcode.test219.minimumJumps;

import java.util.*;

//1654. Minimum Jumps to Reach Home
public class SolutionBFS {
  public int minimumJumps (int[] forbidden, int a, int b, int x) {
    Set<Integer> forbiddenSet = new HashSet<>();
    for (int f : forbidden) {
      forbiddenSet.add(f);
    }
    Set<Jump> visited = new HashSet<>();
    Queue<Jump> queue = new ArrayDeque<>();
    queue.add(new Jump(0));
    int steps = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while(size-- > 0) {
        Jump j = queue.poll();
        if (j.pos == x)
          return steps;
        if (visited.contains(j) || forbiddenSet.contains(j.pos) || j.pos < 0 || j.pos > x + b) {
          continue;
        } else {
          visited.add(j);
          queue.add(new Jump(j.pos + a));
          if(!j.backJump) {
            queue.add(new Jump(j.pos - b, true));
          }
        }
      }
      steps++;
    }
    return -1;
  }

  static class Jump {
    int pos;
    boolean backJump;

    Jump(int p) {
      pos = p;
    }

    Jump(int p, boolean b) {
      pos = p;
      backJump = b;
    }

    @Override public boolean equals (Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Jump jump = (Jump) o;
      return pos == jump.pos && backJump == jump.backJump;
    }

    @Override public int hashCode () {
      return Objects.hash(pos, backJump);
    }

    @Override public String toString () {
      return "Jump{" + "pos=" + pos + ", backJump=" + backJump + '}';
    }
  }

  public static void main (String[] args) {
    SolutionBFS s = new SolutionBFS();
    s.minimumJumps(new int[]{1,6,2,14,5,17,4}, 16,9,7);
  }
}
