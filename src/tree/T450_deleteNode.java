package tree;

import util.TreeNode;

public class T450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        /*
        找到待删除节点后，有三种情况
        1、两边都为空
        2、左或右一边为空
        3、两边都不为空
         */
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root.right);
            // root.val = min.val;
            // root.right = deleteNode(root.right, min.val);
            /*
            这样的改进，避免node结构复杂带来的不便
             能操作指针，就不动节点
             */
            min.left = root.left;
            return root.right;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMin (TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
