package search;

public class T704_search {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        T704_search t = new T704_search();
        System.out.println(t.search(nums, 9));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            /*
            1、使用>>>1可以实现 /2 且避免溢出
            2、使用mid=left+（right-left）/2 避免溢出
             */
            int mid = (left + right)>>>1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
