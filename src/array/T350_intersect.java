package array;

import java.util.ArrayList;

public class T350_intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
         ArrayList<Integer> al = new ArrayList<>();
//        int len = Math.min(nums1.length, nums2.length);
        boolean[] visited = new boolean[nums2.length];
        for (int value : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (value == nums2[j] && !visited[j]) {
                    al.add(nums2[j]);
                    visited[j] = true;
                    break;
                }
            }

        }
        return al.stream().mapToInt(i->i).toArray();
    }
}
