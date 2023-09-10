package com.leetcode.test265.rearrangeBarcodes;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] rearrangeBarcodes (int[] barcodes) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int b : barcodes) {
      map.compute(b, (k, v) -> v == null ? 1 : v + 1);
    }
    final var ref = new Object() {
      int idx = 0;
    };
    map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).forEach(e -> {
      for (int i = 0; i < e.getValue(); i++) {
        if (ref.idx >= barcodes.length)
          ref.idx = 1;
        barcodes[ref.idx] = e.getKey();
        ref.idx += 2;
      }
    });

    return barcodes;
  }
}
