package _301_350;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * <p>
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * <p>
 * Input: "1,#"
 * Output: false
 * Example 3:
 * <p>
 * Input: "9,#,#,1"
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _331_Verify_Preorder_Serialization {
    /**
     * 1ms
     * T = N
     * 一般来说，只给出前序遍历，并不能唯一确定一棵二叉树。但这道题目中还给出了所有空节点的位置，所以可以唯一确定一棵二叉树。
     * <p>
     * 我们用先根顺序递归遍历整棵树，遍历时用一个指针在给定数组中指向当前节点的值，如果遇到#，则说明遇到了空节点，直接return；如果遇到整数，说明遍历到了树中的一个节点，我们先将指针后移，表示先输出根节点，然后依次递归遍历左子树和右子树。
     * 如果递归还没结束但数组已经遍历完，或者递归结束但数组还没遍历完，则说明给定的序列不是一个合法的前序遍历。
     * https://www.acwing.com/solution/content/357/
     */

    boolean ans = true;
    int idx = 0;

    public boolean isValidSerialization(String preorder) {
        preorder += ',';
        dfs(preorder);
        return ans && idx == preorder.length();
    }

    private void dfs(String preorder) {
        if (idx == preorder.length()) {
            ans = false;
            return;
        }

        if (preorder.charAt(idx) == '#') {
            idx += 2;
            return;
        }

        while (preorder.charAt(idx) != ',') {
            idx++;
        }

        idx++;
        dfs(preorder);
        dfs(preorder);
    }
}
