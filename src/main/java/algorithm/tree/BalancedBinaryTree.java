package algorithm.tree;// Source : https://oj.leetcode.com/problems/balanced-binary-tree/
// Inspired by : http://www.jiuzhang.com/solutions/balanced-binary-tree/
// Author : Lei Cao
// Date   : 2015-10-07


/**********************************************************************************
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 * Example
 * Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 * The binary tree A is a height-balanced binary tree, but B is not.
 **********************************************************************************/
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return helper(root, 0).isBalanced;
    }

    private class Result {
        boolean isBalanced;
        int height;

        Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private Result helper(TreeNode root, int depth) {
        if (root == null) {
            return new Result(true, depth);
        }
        Result left = helper(root.left, depth + 1);
        Result right = helper(root.right, depth + 1);

        if (!left.isBalanced || !right.isBalanced) {
            return new Result(false, 0);
        }

        if (Math.abs(left.height - right.height) > 1) {
            return new Result(false, 0);
        }
        return new Result(true, Math.max(left.height, right.height));
    }
}
