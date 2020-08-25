package tree;

import util.TreeNode;

public class T98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null,null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null){
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.right, root, max) &&
                isValidBST(root.left, min, root);
    }


    /*
    解法2：中序遍历
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST_inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST_inOrder(root.left)){
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST_inOrder(root.right);
    }

}
