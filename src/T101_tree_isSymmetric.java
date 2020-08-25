import com.sun.source.tree.Tree;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T101_tree_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym_recursion(root.left, root.right);
    }

    public boolean isSym_recursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSym_recursion(p.left, q.right)
                && isSym_recursion(p.right, q.left);
    }

    public boolean isSym(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.right);
            queue.offer(q.left);
            queue.offer(p.left);
            queue.offer(q.right);
        }
        return true;
    }



}
