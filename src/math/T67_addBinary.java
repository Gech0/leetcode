package math;

public class T67_addBinary {
    //模拟手工二进制加法
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder biSum = new StringBuilder();
        while (i>=0 || j>=0 || carry>0) {
            if (i >= 0) {
                carry += (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                carry += (b.charAt(j--) - '0');
            }
            biSum.append(carry % 2);
            carry /= 2;
        }
        return biSum.reverse().toString();
    }
}
