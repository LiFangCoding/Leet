package leet._251_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    // Decodes your encoded data to tree.
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> buffer = new ArrayList<>();
        preOrder(root, buffer);
        return String.join(",", buffer);
    }

    private void preOrder(TreeNode root, List<String> buffer) {
        if (root == null) {
            buffer.add("#");
            return;
        }
        buffer.add(String.valueOf(root.val));
        preOrder(root.left, buffer);
        preOrder(root.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] slice = data.split(",");
        return inPreOrder(slice);
    }

    // 1. dfs 顺序:
    // 2. dfs 状态:
    // index 要在外部累加，其实应该传引用过去，但是java传不了
    private TreeNode inPreOrder(String[] slice) {
        if (index >= slice.length) {
            return null;
        }

        String val = slice[index++];

        if (val.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = inPreOrder(slice);
        root.right = inPreOrder(slice);
        return root;
    }

    public static void main(String[] args) {
        String s = "hello, 2,";
        String[] sArray = s.split(",");
        System.out.println(sArray.length);
        System.out.println(sArray);
    }

    class Sol2 {
        int idx;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            getSerialize(root, sb);
            return sb.toString();
        }

        private void getSerialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null,");
                return;
            }

            sb.append(root.val + ",");
            getSerialize(root.left, sb);
            getSerialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] vals = data.split(",");
            idx = 0;
            return build(vals);
        }

        private TreeNode build(String[] vals) {
            if (idx > vals.length) {
                return null;
            }

            String s = vals[idx++];
            if (s.equals("null")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = build(vals);
            root.right = build(vals);

            return root;
        }
    }
}
