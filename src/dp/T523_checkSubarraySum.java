package dp;

public class T523_checkSubarraySum {
    /*
    1、k == 0 ，保证不出现除以0异常
    2、arr={0,0},k = 0;
    3、arr = {0}， k = 0;
    4、arr={5,0,0} ,k = 0;
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (nums[i] == 0 && nums[i - 1] == 0 && k == 0) {
                return true;
            }
        }
        if (k == 0) return false;
        for (int i = 1; i < nums.length; i++) {
            if (sum[i] % k == 0) return true;
            for (int j = i - 2; j >= 0; j--) {
                if ((sum[i] - sum[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySum_cui(int[] nums, int k) {
        // 边界值校验
        if (nums.length == 0 || k == 0) {
            return false;
        }

        //  求和
        int[] sum = new int[nums.length];

        int curValue = 0;
        for (int i = 0; i < nums.length; i++) {
            curValue = nums[i] + curValue;
            sum[i] = curValue;
        }

        // 做差计算核心逻辑
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                int diffValue = sum[j] - sum[i];
                if (diffValue % k == 0 && diffValue != 0) {
                    return true;
                }

            }
        }
        return false;
    }


    public static void main(String[] args) {
        T523_checkSubarraySum t = new T523_checkSubarraySum();
        int[] req = {5,0,0};
        System.out.println(t.checkSubarraySum(req, 0));
    }
}
