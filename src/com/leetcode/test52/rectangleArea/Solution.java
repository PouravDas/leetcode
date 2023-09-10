package com.leetcode.test52.rectangleArea;

class Solution {
  public int computeArea (int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

    int aArea = (ay2 - ay1) * (ax2 - ax1);
    int bArea = (by2 - by1) * (bx2 - bx1);

    int yTop = ay2 > by2 ? by2 : ay2;
    int yDown = ay1 > by1 ? ay1 : by1;

    int xTop = ax2 > bx2 ? bx2 : ax2;
    int xDown = ax1 > bx1 ? ax1 : bx1;

    if (yTop <= yDown || xTop <= xDown)
      return aArea + bArea;

    int commonArea = (yTop - yDown) * (xTop - xDown);
    return aArea + bArea - commonArea;
  }
}
