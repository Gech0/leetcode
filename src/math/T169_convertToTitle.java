package math;

public class T169_convertToTitle {
    public String convertToTitle(int n) {
//        char[] dic = new char[26];
//        dic[0] = 'Z';
//        for (int i = 1; i < 26; i++) {
//            dic[i] = (char)(i - 1 + 'A');
//        }
        StringBuilder res = new StringBuilder();
        while((n-1)>=0) {
            n -= 1;
            res.append((char)(n%26+'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T169_convertToTitle().convertToTitle(52));
    }
}
