package algorithm.tree;

/**
 * \* User: lucaskc
 * \* Date: 2017/9/30
 * \* Time: 上午9:37
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeaves(root))
            return 0;
        return sumOfLeftLeavesHelper(root, root.left) +
                sumOfLeftLeavesHelper(root, root.right);
    }

    private int sumOfLeftLeavesHelper(TreeNode parent, TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (isLeaves(node) && parent.left == node) {
            return node.val;
        }

        int left = sumOfLeftLeavesHelper(node, node.left);
        int right = sumOfLeftLeavesHelper(node, node.right);
        return left + right;
    }

    boolean isLeaves(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
