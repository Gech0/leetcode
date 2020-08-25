package array;

public class M0803_findMagicIndex {
    public int findMagicIndex_plain(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public int findMagicIndex_dichotomy(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == nums[mid]) {
                return mid;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,5};
        M0803_findMagicIndex t = new M0803_findMagicIndex();
        System.out.println(t.findMagicIndex_dichotomy(nums));
    }
}
