import util.PrintArrays;

import java.util.Stack;

public class T739_dailyTemperatures {
    public static void main(String[] args) {
        int[] req = {73, 74, 75, 71, 69, 72, 76, 73};
        T739_dailyTemperatures t= new T739_dailyTemperatures();
        int[] res = t.dailyTemperatures(req);
        int[] res1 = t.dailyTemperatures_I(req);
        PrintArrays.printIntArr(res);
        PrintArrays.printIntArr(res1);
    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures_I(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            if (T[i] > stack.peek()) {
                res[i] = stack.size();
                stack.clear();
                stack.push(T[i]);
            }
        }
        return res;
    }
}
