package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TriesPrefixTree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  //we can declare TrieNode this way of
//  public static final int N=26;
//  public TrieNode[] children= new TrieNode[N];
  //Using a table

  Map<Character,TrieNode> children=new HashMap<>();
  boolean isWord=false;
}

/*** Usage:
 * Initialization; TriedNode root=new TrieNode();
 * Return a specific child node with char c: root.children.get(c);
*
* */