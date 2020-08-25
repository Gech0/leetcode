import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int res = solution(n);
            System.out.println(res);
        }

    }

    public static int solution(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++){
            res *= i;
        }
        return res;
    }
}
