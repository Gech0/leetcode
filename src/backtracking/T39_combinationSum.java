package backtracking;

import java.util.*;

public class T39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> combination = new ArrayDeque<>();
        dfs (res, candidates, combination, target, length,0);
        return res;
    }

    /*
    此处设置一个i来剪枝。也就是前面的数字已经处理过了，后面的分支再用前面的数字会导致重复
     */
    private void dfs (List<List<Integer>> res, int[] candidates,
                      Deque<Integer> combination,
                      int target, int length, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = begin; i < length; i++) {
            if (candidates[i] > target) {
                break;
            }
            combination.addLast(candidates[i]);

            // 注意：由于每一个元素可以【重复使用】，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(res, candidates, combination
                    ,target - candidates[i], length, i);
            combination.removeLast();
        }
    }
}
