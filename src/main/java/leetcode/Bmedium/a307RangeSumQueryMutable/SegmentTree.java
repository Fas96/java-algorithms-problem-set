package leetcode.Bmedium.a307RangeSumQueryMutable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SegmentTree {

  @Test
      public void testIfSeqmentTreeIsBuilt(){
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    int n = arr.length;
    int height = (int)(Math.log(n)/Math.log(2)) + 1;
    int tree_nodes = (int) Math.pow(2, height + 1);

    SegmentTree ob = new SegmentTree(tree_nodes);
    ob.build(arr, 0, 0, n - 1);

    assertEquals(20,ob.query(0, 0, n - 1, 0, 5));
  }
  int[] tree;

  SegmentTree(int n){
    tree = new int[n];
  }

  void build(int[] arr, int node, int start, int end){
    if(start == end){
      tree[node] = arr[start];
    }
    else{
      int mid = (start + end)/2;
      build(arr, 2*node + 1, start, mid);
      build(arr, 2*node + 2, mid + 1, end);
      tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }
  }

  void update(int[] arr, int node, int index, int val, int start, int end){
    if(start == end){
      tree[node] += val;
      arr[start] += val;
    }
    else{
      int mid = (start + end)/2;
      if(start <= index && index <= mid){
        update(arr, 2*node + 1, index, val, start, mid);
      }
      else{
        update(arr, 2*node + 2, index, val, mid + 1, end);
      }
      tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }
  }

  int query(int node, int start, int end, int left, int right){
    if(right < start || end < left){
      return 0;
    }
    if(left <= start && end <= right){
      return tree[node];
    }
    int mid = (start + end)/2;
    int p1 = query(2*node + 1, start, mid, left, right);
    int p2 = query(2*node + 2, mid + 1, end, left, right);
    return p1 + p2;
  }
}
