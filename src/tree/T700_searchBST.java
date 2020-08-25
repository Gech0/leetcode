package tree;

import util.TreeNode;

public class T700_searchBST {
    //递归
    public TreeNode searchBST_recursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST_recursion(root.left, val);
        } else {
            return searchBST_recursion(root.right, val);
        }
    }


//  迭代
    public TreeNode searchBST (TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val? root.left : root.right;
        }
        return root;
    }
}
