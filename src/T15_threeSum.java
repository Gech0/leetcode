import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T15_threeSum {
    public static void main(String[] args) {
        T15_threeSum t = new T15_threeSum();
//        int[] req = {-1, 0, 1, 2, -1, -4};
        int[] req = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> res = t.threeSum(req);
        for (List<Integer> l: res) {
            System.out.println(l);
        }
    }

    /*
    检查点：
    1、输入为空
    2、输入刚好3个数字
    3、输入为{0,0,0,0}；
    4、去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[low]);
                    al.add(nums[high]);
//                    if (res.size() == 0
//                            ||!al.equals(res.get(res.size() - 1)))
                        res.add(al);
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        res = res.stream().distinct().collect(Collectors.toList());
        return res;
    }
}
