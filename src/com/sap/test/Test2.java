package com.sap.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Anagram (care race)
 */
public class Test2 {

  public static void main (String[] args) {

  }

  boolean isAnagram (String s1, String s2) {
    if (s1.length() != s2.length())
      return false;

    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for (char c : s1.toCharArray()) {
      map1.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }

    for (char c : s2.toCharArray()) {
      map2.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }

    for (Map.Entry<Character, Integer> e : map1.entrySet()) {
      if(!map2.containsKey(e.getKey())) return false;
      else if (map2.get(e.getKey()) != e.getValue()) return false;
    }

    return true;
  }
}

