
public class T837_new21Game {
    public static void main(String[] args) {
        System.out.println(new T837_new21Game().new21Game(10,1,10));
        System.out.println(new T837_new21Game().new21Game(6,1,10));
        System.out.println(new T837_new21Game().new21Game(21,17,10));
        System.out.println(new T837_new21Game().new21Game(1,0,1));
    }
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W];
//        double temp = N - K + 1;
        double temp = Math.min(N - K + 1, W);
        for (int i = K; i <= N; i++) {
            dp[i] = 1;
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = temp / W;
            temp = temp - dp[i + W] + dp[i];
        }
        return dp[0];
    }

}
