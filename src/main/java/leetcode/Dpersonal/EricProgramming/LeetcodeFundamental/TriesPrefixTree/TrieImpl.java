package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TriesPrefixTree;

public class TrieImpl {
  private TrieNode root;
  public TrieImpl() {
    root=new TrieNode();

  }

  public void insert(String word) {
    TrieNode curNode=root;
    char[] arr=word.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        curNode.children.put(curChar,new TrieNode());
      }
      curNode=curNode.children.get(curChar);
    }
    curNode.isWord=true;
  }

  public boolean search(String word) {
    TrieNode curNode=root;
    char[] arr=word.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        return false;
      }
      curNode=curNode.children.get(curChar);
    }
    return curNode.isWord;
  }
  private boolean match(char[] chs, int k, TrieNode node) {
    TrieNode curNode=root;
    if (k == chs.length) return ! curNode.isWord;
    if (chs[k] != '.') {
      return curNode.children.get(chs[k])!= null && match(chs, k + 1,curNode.children.get(chs[k])  );
    } else {
      for (int i = 0; i < curNode.children.size(); i++) {
        if (curNode.children.get(i) != null) {
          if (match(chs, k + 1,curNode.children.get(i))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean startsWith(String prefix) {
    TrieNode curNode=root;
    char[] arr=prefix.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        return false;
      }
      curNode=curNode.children.get(curChar);
    }
    return true;
  }
}
