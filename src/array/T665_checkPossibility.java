package array;

public class T665_checkPossibility {
    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(new T665_checkPossibility().checkPossibility(nums));
    }
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] <nums[i-1]) {
                cnt++;
                /*
                注：要考虑第一个节点,避免影响更多节点，应该处理第一个节点，
                 */
                if (i-2 >= 0 && nums[i] < nums[i-2]){
                    nums[i] = nums[i - 1];
                } else {
                    nums[i-1] = nums[i];
                }
            }
        }
        return cnt < 2;
    }
}
