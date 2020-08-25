public class T9_isPalindrome {
    public static void main(String[] args) {
        System.out.println(new T9_isPalindrome().isPalindromeI(-121));
        System.out.println(new T9_isPalindrome().isPalindromeI(121));
        System.out.println(new T9_isPalindrome().isPalindromeI(12));
        System.out.println(new T9_isPalindrome().isPalindromeI(12321));
        System.out.println(new T9_isPalindrome().isPalindromeI(0));
    }
    public boolean isPalindrome(int x) {
        StringBuilder xStr = new StringBuilder(String.valueOf(x));
        return String.valueOf(x).contentEquals(xStr.reverse());
    }

    public boolean isPalindromeI(int x) {
        if ((x % 10 == 0 && x!=0)|| x < 0){
            return false;
        }
        int num = x;
        int reverse = 0;
        //这里可能会有溢出情况，需要处理
        while (num != 0) {
            int temp = num % 10;
            reverse = reverse * 10 + temp;
            num /= 10;
        }
        return x == reverse;
    }

    public boolean isPalindromeII(int x) {//控制数字的一半
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse){
            reverse = reverse * 10 + x % 10;
            //x%10 从x的尾部取一位数，  reverse*10,向左移动一位，即增加一位
            x /= 10;
            //去掉x的最后一位数。当reverse>=x时，刚好反转了x的后面一半数
        }
        return x == reverse || x == reverse / 10;//这里的/10是为了去掉中间位
    }
}
