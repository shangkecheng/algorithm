package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * \* User: lucaskc
 * \* Date: 2017/9/30
 * \* Time: 上午11:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class kthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        Result r = kthSmallestHelper(k, list, root);
        return r.find ? r.node.val : -1;

    }

    Result kthSmallestHelper(int k, List<TreeNode> s, TreeNode node) {
        if (s.size() == k) {
            return new Result(true, s.get(k - 1));
        }
        if (node == null) {
            return new Result(false, node);
        }


        Result node_left = kthSmallestHelper(k, s, node.left);
        if (node_left.find) {
            return node_left;
        }

        s.add(node);

        Result node_right = kthSmallestHelper(k, s, node.right);
        if (node_right.find) {
            return node_right;
        }

        return new Result(false, node);
    }


    private class Result {
        boolean find;
        TreeNode node;

        Result(boolean find, TreeNode node) {
            this.find = find;
            this.node = node;
        }
    }

    public int kthSmallestII(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }
}
