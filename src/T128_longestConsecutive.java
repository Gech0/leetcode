import java.util.Arrays;

public class T128_longestConsecutive {
    public static void main(String[] args) {
        T128_longestConsecutive t = new T128_longestConsecutive();
        int[] req = {1,2,0,1};
        System.out.println(t.longestConsecutive(req));
    }
    /*
    注意点：
    1、空数组
    2、重复数字的处理
    3、初始化len==0，而不是等于1
    4、若是一个连续序列，没有中断，则len的数据没机会同步到maxLen，需要特殊处理
    
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = 1;
        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                len++;
            } else if (nums[i] == nums[i+1]){

            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 1;
            }
        }
        return Math.max(len, maxLen);
    }
}
