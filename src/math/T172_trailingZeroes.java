package math;

public class T172_trailingZeroes {
    /*
    只要有一个2，5就可以产生一个0.
    可以分解为5的隔5出现一个，可以分解为2的很多，
    于是只需要考虑1 ~ n，中所有数字，有多少个 数可以分解为5，分解出多少5
     */
    public int trailingZeroes(int n) {
        int res = 0;
        long p = 5L; //注意：在n很大的情况下这里的p可能会越界！！！
        while (p <= n) {
            res += (n / p);
            p *= 5;
        }
        return res;
    }

    /*
    为了避免分母一直乘上去导致溢出，
    故缩小被除数===》
     */

    public int trailingZeroes_plus(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;  //此处先让n变小，还可以减少一次运算
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(new T172_trailingZeroes().trailingZeroes(1808548329));
    }
}
