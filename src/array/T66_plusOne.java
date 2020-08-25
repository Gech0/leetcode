package array;

public class T66_plusOne {
    public static void main(String[] args) {
        int[] nums = {989};
        T66_plusOne t = new T66_plusOne();
        for (int n:t.plusOne(nums)) {
            System.out.print(n + "~");
        }
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1] += 1;
            return digits;
        }
        int carry = 1;
        digits[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] + carry <= 9) {
                digits[i] += 1;
                carry = 0;
                return digits;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}
