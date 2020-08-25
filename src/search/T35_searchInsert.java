package search;

public class T35_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        T35_searchInsert t = new T35_searchInsert();
        System.out.println(t.searchInsert(nums,2));
    }
    /*

     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}
