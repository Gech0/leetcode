package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T119_getRow {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> yanghui = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    level.add(1);
                } else {
                    level.add(yanghui.get(i - 1).get(j - 1) +
                            yanghui.get(i - 1).get(j));
                }
            }
            yanghui.add(level);
        }
        return yanghui.get(rowIndex - 1);
    }

    /*
    思路：类似滚动数组的概念！！
    处理很nice
     */
    public List<Integer> getRow_plus(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < rowIndex + 1; i++) {
            /*
            注意：内层循环必须从右向左，
            如果左向右，会导致需要用到的值，在本轮循环中被修改
             */
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return Arrays.asList(dp);
    }
}
