package operation;

public class T201_rangeBitwiseAnd {
    /*
    公共前缀
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n){
            return m;
        }
        int cnt = 0;
        while (m != n && m * n != 0) {
            m >>= 1;
            n >>= 1;
            cnt ++;
        }
        return m << cnt;
    }
}
