package tree;

import util.TreeNode;

public class T538_convertBST {
    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
     */


    /*
    最精干的思路：
    搜索树===》中序遍历
    首先想到，结果要的是比当前元素大的所有元素的和+当前， ===》先遍历大的元素
    综上===》反向中序遍历

    几乎不需要额外的存储空间
    通过一个sum保存右边所有元素的值，
    通过反方向中续遍历,遍历到某元素t时，sum即为其右边所有元素之和，将t.val + sum即为最终树上的值
     */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            convertBST(root.left);
        }
        return root;
    }

}
