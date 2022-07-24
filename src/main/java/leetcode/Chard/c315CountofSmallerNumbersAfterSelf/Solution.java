package leetcode.Chard.c315CountofSmallerNumbersAfterSelf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public  class Solution {
   class BinaryTree {
    Node root;
    public void add(int value) {
      root = addRecursive(root, value);
    }
    private BinaryTree createBinaryTree(int [] values) {
      BinaryTree bt = new BinaryTree();
      for (int i = 0; i < values.length; i++) {
       bt.add(values[i]);
      }
      return bt;
    }
    private Node addRecursive(Node current, int value) {
      if (current == null) {
        return new Node(value);
      }
      if (value < current.value) {
        current.left = addRecursive(current.left, value);
      } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
      } else {
        return current;
      }
      return current;
    }
  }
  class Node {
    int value;
    Node left;
    Node right;
    Node(int value) {
      this.value = value;
      right = null;
      left = null;
    }
  }

  @Test
  public void countSmaller_test(){
    assertEquals(Arrays.asList(0,0),countSmaller(new int[]{5,2,6,1}));
  }
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> res=new ArrayList<>();
    System.out.println("Heder");
    BinaryTree s= new BinaryTree();
    BinaryTree sroot=s.createBinaryTree(nums);

    traversePostOrder(sroot.root);
    return  res;
  }
  public void traversePostOrder(Node node) {
    if (node != null) {
      traversePostOrder(node.left);
      traversePostOrder(node.right);
      System.out.print(" " + node.value);
    }
  }
  public void traverseInOrder(Node node) {
    if (node != null) {
      traverseInOrder(node.left);
      System.out.print(" " + node.value);
      traverseInOrder(node.right);
    }
  }
  public void traversePreOrder(Node node) {
    if (node != null) {
      System.out.print(" " + node.value);
      traversePreOrder(node.left);
      traversePreOrder(node.right);
    }
  }
}