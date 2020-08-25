package operation;

import java.util.HashSet;
import java.util.Set;

public class T136_singleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        return set.iterator().next();
    }

    /*
    本题考查的是异或的应用
    异或运算有记忆性
    规则：
    1、0 ^ x = x
    2、x ^ x = 0
     */
    public int singleNumber_xor(int[] nums) {
        // if (nums.length == 0) return 0;
        int bit = 0;
        for (int n: nums) {
            bit ^= n;
        }
        return bit;
    }

}
