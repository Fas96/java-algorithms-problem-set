package leetcode.Eweekly.w319;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Q3 {

    @Test
    public void testSol(){

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
  //In one operation, you can choose any two nodes at the same level and swap their values.
    public int minimumOperations(TreeNode root) {
        int result=0;
        List<List<Integer>> levelList=levelOrder(root);
        System.out.println(levelList);
        for(List<Integer> level:levelList){
            int[] arr=new int[level.size()];
            for(int i=0;i<level.size();i++){
                arr[i]=level.get(i);
            }
            result+=minOps(arr);
        }
        return result;

    }

    private int minOps(int[] nums) {

        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++)
            map.put(nums[i], i);

        Arrays.sort(nums);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        // Initialize result
        int ans = 0;
        for(int i=0;i<len;i++) {

            // already swapped and corrected or
            // already present at correct pos
            if(visited[i] || map.get(nums[i]) == i)
                continue;

            int j = i, cycle_size = 0;
            while(!visited[j]) {
                visited[j] = true;

                // move to next node
                j = map.get(nums[j]);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if(cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        callStackLevels(ans,root,0);
        return ans;
    }

    private void callStackLevels(List<List<Integer>> ans, TreeNode root, int i) {
        if(root==null) return;
        if(ans.size()==i){
            ans.add(new LinkedList<>());
        }
        ans.get(i).add(root.val);
        callStackLevels(ans,root.left,i+1);
        callStackLevels(ans,root.right,i+1);
    }


}
