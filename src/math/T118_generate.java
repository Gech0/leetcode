package math;

import java.util.ArrayList;
import java.util.List;

public class T118_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < i; j++) {
                level.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0)
                level.add(1);
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new T118_generate().generate(5));
    }
}
