package array;

import java.util.HashMap;
import java.util.Map;

public class T167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(target - numbers[i]), i};
            }
        }
        return new int[0];
    }

    //利用题目条件，有序，用双指针
    public int[] twoSum_I(int[] numbers, int target) {
        //注意题目给出条件：升序排列
        int min = 0, max = numbers.length - 1;
        while (min <= max) {
            int val = numbers[min] + numbers[max];
            if (val == target){
                return new int[]{min+1, max+1};
            } else if(val < target) {
                min++;
            } else {
                max--;
            }
        }
        return new int[0];
    }
}
