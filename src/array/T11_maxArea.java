package array;

public class T11_maxArea {
    //双指针：需要移动左右两边的问题
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left],height[right]);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
