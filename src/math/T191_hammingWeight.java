package math;

public class T191_hammingWeight {
    // you need to treat n as an unsigned value

    /*
    Q：java中没有无符号整数，所以如何处理？

     */

    /*
    注：以下这种解法是错的，正数的case是没有问题的，但是负数的就会出错
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                sum++;
            }
            n /= 2;
        }
        return sum;
    }


    /*
    思路:
    再看到这种类型的题目，首先想，能不能用位运算？？？

    注：位运算的优先级比较低，要写上括号！
    （*2，/2 这种类型的运算用 移位）
     */

    public int hammingWeight_bit(int n) {
        int mask = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            n >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T191_hammingWeight().hammingWeight_bit(11));
    }

}
