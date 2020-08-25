package operation;

public class Offer56_singleNumbers {
    /*
    key words: 位运算（异或、与、移位），分组
    假设2个只出现1次的数是a、b。
    1、使nums中所有元素进行异或操作 ==》
    其中相同的两两得0，结果的意义是：a^b 的值
    2、得到 a^b 二进制中，任意一位是1的，的位置
    3、将nums中数据分成两组，
    a^b ==1 的某一位
     */
    public int[] singleNumbers(int[] nums) {
        int p = 0; // a^b
        for (int n: nums) {
            p ^= n;
        }
        int q = 1;
        while ((p & q) == 0) {
            q <<= 1;
        }
        int n1 = 0 , n2 = 0;//两个数字结果
        for (int n: nums) {
            if ((q & n) == 0) {//分组进行异或
                n1 ^= n;
            } else{
                n2 ^= n;
            }
        }
        return new int[]{n1,n2};
    }
}
