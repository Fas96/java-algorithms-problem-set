
/*
* 6223. Height of Binary Tree After Subtree Removal Queries
User Accepted:0
User Tried:0
Total Accepted:0
Total Submissions:0
Difficulty:Hard
You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.

You have to perform m independent queries on the tree where in the ith query you do the following:

Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.

Note:

The queries are independent, so the tree returns to its initial state after each query.
The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.

* */
class TreeNode {
      val: number
      left: TreeNode | null
      right: TreeNode | null
      constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
          this.val = (val===undefined ? 0 : val)
          this.left = (left===undefined ? null : left)
          this.right = (right===undefined ? null : right)
      }
  }

  function treeQueries(root: TreeNode | null, queries: number[]): number[] {
        let ans = [];
        let map = new Map();
        let count = 0;
        let max = 0;
        let dfs = (node: TreeNode | null) => {
            if (node === null) return 0;
            let left = dfs(node.left);
            let right = dfs(node.right);
            let sum = left + right + 1;
            map.set(node.val, sum);
            count = Math.max(count, sum);
            return sum;
        }
        dfs(root);
        for (let i = 0; i < queries.length; i++) {
            let val = queries[i];
            if (map.has(val)) {
                count = Math.max(count, map.get(val));
                map.delete(val);
            }
            ans.push(count);
        }
        return ans;

};