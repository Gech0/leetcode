package tree;

import util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class T111_minDepth {
    /*
    思路：层序遍历，数层数，数到某个节点是叶子结点，直接返回当前层数
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            /*
            必写，否则 输入空树，会引起空指针异常！
             */
            return 0;
        }
        Queue<TreeNode> level = new LinkedList<>();
        int count = 0;
        level.add(root);
        int depth = 1;
        while (!level.isEmpty()) {
            count = level.size();
            while (count > 0) {
                TreeNode cur = level.poll();
                count--;
                if (cur.left == null && cur.right== null){
                    return depth;
                }
                if (cur.left != null) {
                    level.add(cur.left);
                }
                if (cur.right != null) {
                    level.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepth_recursion(TreeNode root) {
        /*
        叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
        当 root 节点左右孩子都为空时，返回 1
        当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
        当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
         */
        if (root == null) {
            return 0;
        }
        int left = minDepth_recursion(root.left);
        int right = minDepth_recursion(root.right);
        if (root.left == null || root.right == null) {
            return 1 + left + right; //left和right必然有一个为空，所以可以这样写
        }
        return Math.min(minDepth_recursion(root.left), minDepth_recursion(root.right)) + 1;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new T111_minDepth().minDepth_recursion(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
