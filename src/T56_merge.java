import java.util.Arrays;

public class T56_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals);
        System.out.println(intervals);
        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        new T56_merge().merge(intervals);
    }
}
