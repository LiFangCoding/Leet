package leet._251_300;

import common.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example: 
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class _297_SerializeAndDeserializeBinaryTree {
    class Sol_dfs {
        public class Codec {
            StringBuilder sb;

            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                dfsS(root);
                return sb.toString();
            }

            void dfsS(TreeNode root) {
                if (root == null) {
                    sb.append("#,");
                } else {
                    sb.append(root.val);
                    sb.append(",");
                    dfsS(root.left);
                    dfsS(root.right);
                }
            }

            String data;
            int u = 0;

            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                this.data = data;
                return dfsD();
            }

            TreeNode dfsD() {
                if (data.charAt(u) == '#') {
                    u += 2;
                    return null;
                } else {
                    int k = u;
                    while (data.charAt(u) != ',') {
                        u++;
                    }
                    //can work for negative like -123
                    TreeNode root = new TreeNode(Integer.parseInt(data.substring(k, u)));
                    u++;
                    root.left = dfsD();
                    root.right = dfsD();
                    return root;
                }
            }
        }
    }
}
