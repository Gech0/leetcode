package math;

public class T8_myAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        String res;
        int num = 0;
        int index = 0;
        int i = 1;
        while (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                i++;
        }
//        if (i == 1 && ) {
//            return
//        }
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            res = str.substring(0, i);
            num = Integer.parseInt(res);
        }
        return 0;
    }
}
