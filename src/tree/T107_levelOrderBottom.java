package tree;

import util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;  //注意：树为空的时候，返回[],而不是null
        Queue<TreeNode> que = new ArrayDeque<>();
        TreeNode last = root;
        que.add(root);
        List<Integer> list = new ArrayList<>();
        TreeNode point = root;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            list.add(cur.val);
            if (cur.left != null) {
                que.add(cur.left);
                point = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                point = cur.right;
            }

            if (cur == last) {
                last = point;
                List<Integer> al = new ArrayList<>(list);//注：如果只是al=list, 则al只得到list的应用，clear的时候也会清掉
                res.add(al);
                list.clear();
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom_fast(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();//用于保存一层的节点值
        Stack<List<Integer>> stack = new Stack<>();
        /*
        考虑一下，LinkedList 和 ArrayDeque 的效率哪个好？？？？
         */
        Queue<TreeNode> queue = new LinkedList<>(); //= new ArrayDeque<>()
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size(); //注：在这里要求一下当前的size，
            List<Integer> levelNodes = new ArrayList<>();
            while (size > 0) {
                /*
                此处size判断的是上面的size
                不能现取size，会考虑到刚加进去的元素
                 */
                TreeNode cur = queue.remove();
                size--;
                levelNodes.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            stack.add(levelNodes);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

}
