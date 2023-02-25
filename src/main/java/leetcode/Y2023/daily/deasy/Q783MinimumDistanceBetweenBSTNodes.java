package leetcode.Y2023.daily.deasy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q783MinimumDistanceBetweenBSTNodes {
    @Test
    public void test(){
       assertEquals(minDiffInBST(TreeNode.of(27,null,34,null,58,50,null,44)),6);
       assertEquals(minDiffInBST(TreeNode.of(4,2,6,1,3)),1);
       assertEquals(minDiffInBST(TreeNode.of(1,0,48,null,null,12,49)),1);
    }

    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root,list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff,list.get(i)-list.get(i-1));
        }
        return minDiff;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root==null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
