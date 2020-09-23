package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T216_combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
//        if (n > 50) return res;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, n, res, path, 0, 1);
        return res;
    }

    private void dfs (int k, int n, List<List<Integer>> res, Deque<Integer> path, int depth, int start) {
        if (depth == k) {
            if (n == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            path.addLast(i);
            dfs(k, n - i, res,path, depth + 1, i + 1);
            path.removeLast();
        }
    }
}

