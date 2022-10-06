package leetcode.Bmedium.a449SerializeandDeserializeBST;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class a449SerializeandDeserializeBST {
      //test that root=[] will return []
        @Test
        public void test() {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            Codec codec = new Codec();

        }
        //test that root=empty will return []






        public class Codec {

            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                StringBuilder sb = new StringBuilder();
                serialize(root, sb);
                return sb.toString();
            }

            private void serialize(TreeNode root, StringBuilder sb) {
                if (root == null) return;
                sb.append(root.val).append(",");
                serialize(root.left, sb);
                serialize(root.right, sb);
            }

            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                String[] nodes = data.split(",");
                return deserialize(nodes, 0, nodes.length - 1);
            }

            private TreeNode deserialize(String[] nodes, int start, int end) {
                if (start > end) return null;
                TreeNode root = new TreeNode(Integer.parseInt(nodes[start]));
                int i = start + 1;
                while (i <= end && Integer.parseInt(nodes[i]) < root.val) i++;
                root.left = deserialize(nodes, start + 1, i - 1);
                root.right = deserialize(nodes, i, end);
                return root;
            }
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }





}
