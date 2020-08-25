package math;

public class T415_addStrings {
    /*
    1、若两数字位数相同，且加后又进位，运算结束需要再加一位！
    2、注意，进位的要求是 >=10
     */
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "9";
        System.out.println(new T415_addStrings().addStrings_plus(s1,s2));
    }
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int isCarry = 0;

        int i = len1 - 1;
        int j = len2 - 1;
        while (i >= 0 && j >= 0){
            int temp = num1.charAt(i--) + num2.charAt(j--) - 2 * '0' + isCarry;
            if (temp >= 10) {
                isCarry = 1;
                temp -= 10;
            } else {
                isCarry = 0;
            }
            sb.append(temp);
        }
        while (i >= 0) {
            int temp = num1.charAt(i) - '0' + isCarry;
            if (temp >= 10) {
                isCarry = 1;
                temp -= 10;
            } else {
                isCarry = 0;
            }
            sb.append(temp);
            i--;
        }
        while (j >= 0) {
            int temp = num2.charAt(j) - '0' + isCarry;
            if (temp >= 10) {
                isCarry = 1;
                temp -= 10;
            } else {
                isCarry = 0;
            }
            sb.append(temp);
            j--;
        }

        if (isCarry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public String addStrings_plus (String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry = carry + num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry = carry + num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
