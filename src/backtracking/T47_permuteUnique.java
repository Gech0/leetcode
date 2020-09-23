package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] isUsed = new boolean[length];
        Arrays.sort(nums);
        dfs(nums, res, path, isUsed, length, 0);
        return res;
    }


    private void dfs (int[] nums, List<List<Integer>> res,
                      Deque<Integer> path, boolean[] isUsed,
                      int length, int depth){
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (isUsed[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && !isUsed[i-1]) continue;
            path.addLast(nums[i]);
            isUsed[i] = true;
            dfs(nums, res, path, isUsed, length, depth + 1);
            path.removeLast();
            isUsed[i] = false;
        }

    }




    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
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
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new T47_permuteUnique().permuteUnique(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
