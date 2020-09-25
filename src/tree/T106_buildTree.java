package tree;

import util.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author guoxuechun
 * @date 2020/9/25 11:41
 */
public class T106_buildTree {
    /*
    从中序遍历和后序遍历序列，重建二叉树
    类似前序+中序，重点是搞清楚 数组怎么分开
     */

    /*
    思路一：
    简单粗暴，给出一棵树，递归，分别建立其左子树，右子树。
    用Arrays.copyOfRange方法分割出左子树，右子树的中序遍历，后序遍历顺序

    效率较低
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == rootVal) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, inorder.length - 1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }

    /*
    思路二：
    用一个辅助函数，通过传递数组下标来避免申请很多的子数组
    比第一种快，但是位置容易写错
     */
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;
    public TreeNode buildTree_fast(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree (int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootVal = post[pEnd];
        int rootPos = memo.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(iStart, rootPos - 1, pStart, pStart + rootPos - iStart - 1);
        root.right = buildTree(rootPos + 1, iEnd, pStart + rootPos - iStart, pEnd - 1);
        return root;
    }
}
