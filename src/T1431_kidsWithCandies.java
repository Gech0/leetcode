import java.util.ArrayList;
import java.util.List;

public class T1431_kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
//            if (candies[i] > max) {
//                max = candies[i];
//            }
            //优化
            max = Math.max(max, candies[i]);

        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(max - candies[i] <= extraCandies);
        }
        return result;
    }
}
