public class T7_reverse {
    public static void main(String[] args) {
        System.out.println(new T7_reverse().reverse(120));
        System.out.println(new T7_reverse().reverse_I(-123));
        System.out.println(new T7_reverse().reverse_I(0));
        System.out.println(new T7_reverse().reverse_I(1534236469));
    }
    public int reverse (int x) {
        if (x == -Math.pow(2, 31) || x == 0) {
            return 0;
        }
        boolean isPos = false;
        isPos = (x >= 0);
        if (x < 0) {
            x = - x;
        }
        StringBuilder res = new StringBuilder(String.valueOf(x));
        res = res.reverse();
        int index = 0;
        while(index < res.length() && res.charAt(index) == '0'){
            index ++;
        }
        try {
            int part = Integer.parseInt(res.substring(index));
            return isPos? part : -part;
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public int reverse_I (int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            //上溢：7是2^31-1的个位数，也就是如果除最后一位已经和max_value一致，最后一位超过了7就要进行溢出处理
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE/10 && pop > 7)){
                return 0;
            }
            //负数下溢
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && ans < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
