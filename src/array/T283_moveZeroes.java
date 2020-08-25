package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class T283_moveZeroes {
    public void moveZeroes(int[] nums) {
        Queue<Integer> que = new ArrayDeque<>();
        for (int num : nums) {
            if (num != 0) {
                que.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (que.isEmpty()) {
                Arrays.fill(nums, i, nums.length, 0);
                break;
            }
            nums[i] = que.poll();
        }
    }

    public void moveZeroes_I(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,2,0,5};
        new T283_moveZeroes().moveZeroes_I(nums);
        for (int n:nums) {
            System.out.print(n+" ");

        }

    }
}
