package math;

public class T190_reverseBits {
    public int reverseBits(int n) {
        StringBuilder sn = new StringBuilder();
        int res = 0;
        while (n != 0) {
            /*
            注：这里不能写n>0，因为java没有无符号整数，所以输入的时候有可能超出了java中int的范围，
            n在java中的值 <0
             */
            sn.append(n % 2);
            n >>>= 1;
        }
        while (sn.length() < 32) {
            /*
            注： len < 32 的时候才需要append
             */
            sn.append('0');
        }
        for (int i = 0; i < sn.length(); i++) {
            int cur = sn.charAt(i) - '0';
            res = (res << 1) + cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T190_reverseBits().reverseBits(43261596));
    }
}
