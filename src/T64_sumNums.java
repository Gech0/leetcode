public class T64_sumNums {
    public static void main(String[] args) {
        System.out.println(new T64_sumNums().sumNums(9));
    }
    public int sumNums(int n) {
        if (n <= 1) {
            return n;
        }
        return sumNums(n - 1) + n;
    }
}
