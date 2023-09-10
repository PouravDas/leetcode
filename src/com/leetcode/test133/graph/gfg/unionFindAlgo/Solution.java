package com.leetcode.test133.graph.gfg.unionFindAlgo;

//https://practice.geeksforgeeks.org/problems/union-find/1
class Solution
{
  //Function to merge two nodes a and b.
  public void union_(int a, int b, int par[], int rank[])
  {
    int x = findParent(a, par);
    int y = findParent(b, par);

    if(x == y) return;
    else if(rank[x] == rank[y]){
      par[x] = y;
      rank[x]++;
    } else if(rank[x] < rank[y]){
      par[y] = x;
    } else {
      par[x] = y;
    }
  }

  //Function to check whether 2 nodes are connected or not.
  public Boolean isConnected(int a, int b, int par[], int rank[])
  {
    return findParent(a,par) == findParent(b,par);
  }

  private int findParent(int x, int[] par){
    if(par[x] == x) return x;
    int p = findParent(par[x],par);
    par[x] = p;
    return p;
  }
}
