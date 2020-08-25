package array;

public class T88_merge {
    /*
    从前向后！
    时间复杂度较高 o(n^2)?
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        i,j 分别指向 nums1，nums2，的待处理元素
        i也即处理过的元素总数
         */
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                //借助插入排序的思路，把较大的移到后面， 再放入
                for (int k = m - 1; k >= i ; k--) {
                    nums1[k+1] = nums1[k];
                }
                nums1[i++] = nums2[j++];
                m++; //m:num1中元素的个数，插入nums2中的元素后需要+1
            } else {
                i++; //若 nums1中元素更小，则不需要处理
            }
        }
        while (j < n){
            nums1[i++] = nums2[j++];
        }
    }

    /*
    改进算法：从后向前排序
    避免反复移动元素！！
     */
    public void merge_plus(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
            //一句话代码
            
        }
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }




        public static void main(String[] args) {
        int[] nums1 = {2,3,7,9,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {1,2,4,5,11};
        T88_merge t = new T88_merge();
        t.merge_plus(nums1,4,nums2, 5);
        for (int i: nums1) {
            System.out.print(i + " ");
        }
    }
}
