package backtracking;

import java.util.*;

/*
全排列
——回溯法解决 （深度优先，状态回退）
 */
public class T46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }

        /*
        注意： ArrayDeque是双端队列，可以作为队列或栈使用，且效率比LinkedList、stack更高
         */
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] isUsed = new boolean[length];
        dfs(nums, length, 0, path, res, isUsed);
        return res;
    }
    private void dfs (int[] nums, int length, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] isUsed) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //在非叶子节点处，产生不同的分支
        for (int i = 0; i < length; i++) {
            if (isUsed[i]) {
                continue;
            }
            path.addLast(nums[i]);
            isUsed[i] = true;
            dfs(nums, length, depth + 1, path, res, isUsed);
            //下面就是{回溯}，表示由深层节点返回浅层节点。过程与上面的相反
            path.removeLast();
            isUsed[i] = false;
        }

    }
}
