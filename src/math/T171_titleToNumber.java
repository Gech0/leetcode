package math;

public class T171_titleToNumber {
    /*
    这道题的逆向：T168，这两道题比较着看，
    168第一次比较难想到，对比一下
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T171_titleToNumber().titleToNumber("AB"));
    }
}
