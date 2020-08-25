package tree;

import util.TreeNode;

public class T110_isBalanced {
    /*
    以下代码是典型错误示范，只考虑局部，不考虑整体
     */
//    public boolean isBalanced(TreeNode root) {
//        if ((root == null) || (root.left == null && root.right == null)) {
//            return true;
//        }
//        if (root.right == null && (root.left.right != null ||root.left.left != null)) {
//            return false;
//        }
//        if (root.left == null && (root.right.right != null ||root.right.left != null)) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }


    public boolean isBalanced (TreeNode root) {
//        return recur(root) != -1;
        return height(root) != -1;
    }

    private int recur (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    private int height (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight>=0&&rightHeight>=0&&Math.abs(leftHeight - rightHeight) < 2) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}
