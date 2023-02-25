package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.Ps;
import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q103BinaryTreeZigzagLevelOrderTraversal {
    @Test
    public void test() {
        TreeNode root = TreeNode.of(3,9,20,null,null,15,7);
         List<List<Integer>> ans= Ps.intList("[[3],[20,9],[15,7]]");
        assertEquals(zigzagLevelOrder(root), ans);
        root=TreeNode.of(1);
        ans=Ps.intList("[[1]]");
        assertEquals(zigzagLevelOrder(root), ans);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        calc(root,  ans,0);
        return ans;
    }

    private void calc(TreeNode root, List<List<Integer>> ans, int level) {
        if(root==null)return;
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        if(level%2==0){
            ans.get(level).add(root.val);
        }else{
            ans.get(level).add(0,root.val);
        }
        calc(root.left,ans,level+1);
        calc(root.right,ans,level+1);
    }
}
