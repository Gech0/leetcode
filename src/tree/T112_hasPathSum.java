package tree;

import util.TreeNode;

public class T112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return root.val == sum;
            /*
            下面的两个else if 都可以合并到最后一个
             */
//        } else if (root.right == null) {
//            return hasPathSum(root.left, sum - root.val);
//        } else if (root.left == null){
//            return hasPathSum(root.right, sum - root.val);
        } else {
            return hasPathSum(root.right, sum - root.val)
                    || hasPathSum(root.left, sum - root.val);
        }
    }
}
