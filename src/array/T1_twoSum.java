package array;

import java.util.HashMap;

public class T1_twoSum {
    public static void main(String[] args) {
        int[] request = {3, 2, 4};
        System.out.println(twoSum(request, 6)[0]+" "+twoSum(request, 6)[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }


}
