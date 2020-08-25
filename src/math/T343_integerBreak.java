package math;

public class T343_integerBreak {
    public int integerBreak_math(int n) {
        int remainder = n % 3;
        double res = 0;
        switch (remainder){
            case 0:
                res = Math.pow(3, n/3);
                break;
            case 1:
                res = Math.pow(3, n/3 - 1) * 4;
                break;
            case 2:
                res = Math.pow(3, n/3) * 2;
        }
        return (int)res;
    }

    public int integerBreak_dp (int n) {
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new T343_integerBreak().integerBreak_math(10));
    }
}
