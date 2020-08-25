package array;

public class T189_rotate {
    /*
    输入：[-1], 2, 右移的位数有可能 大于 数组长度
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // if (len == 1) {
        //     return;
        // }
        if (k >= len) {
            k %= len;
        }
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
