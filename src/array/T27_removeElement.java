package array;

public class T27_removeElement {
    public int removeElement(int[] nums, int val) {
        int cnt = 0; //cnt: 不等于val的元素个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }


    /*
    利用题目条件：可以改变顺序
    操作后面的元素
    减少复制次数
     */
    public int removeElement_II(int[] nums, int val) {
        int cnt = nums.length;
        for (int i = 0; i < cnt;) {
            if (nums[i] == val) {
                nums[i] = nums[cnt-1];
                cnt--; //从后面补过来的元素需要重新检查，所以不能操作检查指针，i++
            } else {
                i++; //注意，只有这种情况可以操作i++
            }
        }
        return cnt;
    }
}
