package leetcode.Bmedium.a105ConstructBinaryTreefromPreorderandInorderTraversal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import leetcode.Bmedium.a102BinaryTreeLevelOrderTraversal.a102BinaryTreeLevelOrderTraversal;
import org.junit.Test;

public class a105ConstructBinaryTreefromPreorderandInorderTraversal {
  @Test
  public void listGen_test(){
    Solution s= new Solution();
    System.out.println(s.buildHelp(new int[]{3,9,20,15,7},new int[]{}));
    assertEquals(null,false);
  }
  public static void main(String[] args) {
    System.out.println();
  }
  class Solution {
    List<int[]>  res=null;
    boolean tr=true;
    int inc=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//      Inorder(Left Root, Right)
//      preOrderly ((Root, Left, Right) )
//      [3,9,20,15,7], inorder = [9,3,15,20,7]
      //   [3,9,20,15,7]      [0],[0,0],[0,0,0,0],[0,0,0,0,0,0,0,0]
      //2^(h+1)-1.  == 2^(6)
//          3
//     9         20
//  null|null 15      7
//         null|null null|null
//      return   buildHelp(null,preorder,inorder)
      if(tr) {
        res = buildHelp(preorder, inorder);
        tr=false;
      }


     if(Arrays.stream(res.get(inc)).boxed().collect(Collectors.toList()).parallelStream().allMatch(i -> i == 0)){
       return new TreeNode();
     }
     TreeNode root= new TreeNode(res.get(inc)[0]);
     root.left=buildTree(res.get(inc++), res.get(inc++) );
     root.right=buildTree(res.get(inc++), res.get(inc++) );

      return root;
    }




    private  List<int[]>   buildHelp(int[] preorder, int[] inorder){
      List<Integer> list = Arrays.stream(preorder).boxed().collect(Collectors.toList());
      List<int[]> res= new ArrayList<>();
      int inc=0;
      for (int i = 0; i < preorder.length; i++) {
        int[] ls =new int[(int)Math.pow(2,i)];
        for (int j = ls.length-1; j > -1; j--) {
          if(list.size()==0)break;
          ls[j] = list.remove(0);
        }
        res.add(ls);
        inc++;
        if(list.size()==0)break;

      }
//      root= new TreeNode(res.get(0)[0],null,null);

//      for (int[] r : res) {
//        int a=0;
//        for (int i = r.length-1; i >-1; i--) {
//          if(root.left==null && a==0){
//            root.left=new TreeNode(r[i],null,null);
//            a+=1;
//          }
//          if(root.right==null){
//            root.right=new TreeNode(r[i],null,null);
//            a=0;
//          }
//
//        }
//      }

      return res;
    }
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
