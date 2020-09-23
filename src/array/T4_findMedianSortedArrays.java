package array;

public class T4_findMedianSortedArrays {
    /**
     *寻找两个正序数组的中位数
     *
     * 三种思路解决这个问题：

     */
    /*
    思路一：
    1、另开一个数组num保存所有数据，保证num有序
    2、直接取num的中位数即可
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int i = 0;
        int p = 0;
        int q = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                num[i++] = nums1[p++];
            } else {
                num[i++] = nums2[q++];
            }
        }
        while (p < nums1.length) {
            num[i++] = nums1[p++];
        }
        while (q < nums2.length) {
            num[i++] = nums2[q++];
        }
        if (num.length % 2 == 0) {
            double pre = num[num.length / 2  - 1];
            double post = num[num.length / 2];
            return (pre + post) / 2;
        }
        return num[num.length / 2];
    }

    /*
    思路2：
    1、设置一个指针，找到中位数的位置
    数数字一直找到第 （len1+len2）/2个，eg：合起来有5个数，则

    问题：如何兼顾奇数、偶数个数字的中位数？？？
    我的解决方法：
    设立两个变量保存两个数，pre，post，在遍历中同步后移
    如果是偶数个的话，中位数是（pre+post）/2
    如果是奇数个，中位数是，post
    (比起第一种方法，节省了空间)
     */
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int count = 0;
        double pre = 0;
        int post = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p = 0;
        int q = 0;
        while (p < len1 && q < len2 && count <= (len1 + len2)/2 ) {
            pre = post;
            if (nums1[p] < nums2[q]) {
                post = nums1[p++];
            } else {
                post = nums2[q++];
            }
            count++;
        }
        while (p < len1 && count <= (len1 + len2)/2) {
            pre = post;
            post = nums1[p++];
            count++;
        }

        while (q < len2 && count <= (len1 + len2)/2) {
            pre = post;
            post = nums2[q++];
            count++;
        }
        if ((len1 + len2) % 2 == 0) {
            //如果两个数组的个数和是偶数，需要找到两个数字
            return (pre + post) / 2;
        } else {
            return post;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2,4,5};
        System.out.println(new T4_findMedianSortedArrays().findMedianSortedArrays_2(num1, num2));
    }
}
