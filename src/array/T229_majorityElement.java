package array;

import java.util.ArrayList;
import java.util.List;

public class T229_majorityElement {
    /*
    摩尔投票法：进阶
    1、若三个数都不相同，全部抵消
    2、若三个数中存在相同元素，计数
    3、若已经没有可抵消的，换候选人
     */
    /*
    这道题的隐含条件，最多只能有两个值，
    若代表 >=3 ，则不能保证每个代表的票数都 > 1/3

    需要初始化两个候选人，但是不能确认得到的2个都是最终结果，
    所以需要再遍历一遍 对两个候选人的票数进行判断
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int can1 = nums[0], count1 = 0;
        int can2 = nums[0], count2 = 0;
        for (int can:nums) {
            if (can == can1) {
                count1++;
                continue;
            }
            if (can == can2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                can1 = can;
                count1++;
                continue;
            }
            if (count2 == 0) {
                can2 = can;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int can:nums) {
            if (can == can1) {
                count1++;
            } else if (can == can2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(can1);
        }
        if (count2 > nums.length/3) {
            res.add(can2);
        }
        return res;
    }
}
