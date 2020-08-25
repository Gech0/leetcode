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
            size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            while (size > 0) {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = new T107_levelOrderBottom().levelOrderBottom_fast(root);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }

}
