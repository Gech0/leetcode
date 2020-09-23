package tree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> levelNode = new ArrayDeque<>();
        double sum = 0;
        int num = 1;
        levelNode.add(root);
        while (!levelNode.isEmpty()) {
            int size = levelNode.size();
//            sum += temp.val;
//            num++;
            while (size > 0) {
                TreeNode temp = levelNode.poll();
                size--;
                if (temp.left != null) {
                    levelNode.add(temp.left);
                    num++;
                    sum += temp.left.val;
                }
                if (temp.right != null) {
                    levelNode.add(temp.right);
                    num++;
                    sum += temp.left.right.val;
                }
            }
            res.add(sum / num);
            sum = 0;
            num = 1;
        }
        return res;
    }
}
