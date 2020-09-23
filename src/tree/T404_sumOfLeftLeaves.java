package tree;

import util.TreeNode;

import java.util.Stack;

public class T404_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && isLeaf(root.left)) {
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right);
    }

//    public int sumOfLeftLeaves_nonRecur (TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        if (root == null) return 0;
//        stack.push(root);
//
//
//    }


    public boolean isLeaf (TreeNode t) {
        return t != null && t.left == null && t.right == null;
    }
}
