import java.util.Arrays;

public class T204_countPrimes {
    /*
    测试点：
    1、 n=1
    2、 n=2
    3、 n=1500000（n超大，会超出时间限制）
     */
    public static void main(String[] args) {
        T204_countPrimes t = new T204_countPrimes();
        System.out.println(t.countPrimes(1500000));
    }

    //效率低，会超时
    public int countPrimes0(int n) {
        if (n <= 2) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    res++;
                    break;
                }
            }
        }
        return n - res - 2;

    }


    /*
    1/ 改进1，排除质数的倍数， i*2, i*3, i*4...
    2/ 改进2，去掉遍历中的重复，只需遍历到 sqrt（n）
     */
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    public int countPrimesII(int n) {
        if (n <= 2) return 0;
        boolean[] isPrim = new boolean[n];
        int count = n / 2;
        double ceil = Math.sqrt(n);
        for (int i = 3; i <= ceil ; i += 2) {
            if (isPrim[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrim[j]) {
                    count --;
                    isPrim[j] = true;
                }
            }
        }
        return count;
    }
}
