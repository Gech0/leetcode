public class T238_productExceptSelf {
    public static void main(String[] args) {
        int[] input = {0,1};
        int[] input1 = {0,0};
        int[] input2= {1,2,3,4};
        int[] input3 = {0,1,3,4};
        int[] output =  productExceptSelfI(input);
        int[] output1 =  productExceptSelfI(input1);
        int[] output2 =  productExceptSelfI(input2);
        int[] output3 =  productExceptSelfI(input3);
        for (int i:output) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:output1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:output2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:output3) {
            System.out.print(i + " ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int positive = 1;
        int zero = 0;
        for (int i: nums) {
            if (i != 0) {
                positive *= i;
            }else {
                zero ++;
            }
        }
        if (zero >= 2) {
            return output;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero == 1) {
                output[i] = (nums[i] == 0)?  positive : 0;
            } else {
                output[i] = positive/nums[i];
            }
        }
        return output;
    }

    /*
    思路：结果集中 = 当前元素左边乘积 * 右边乘积
     */
    public static int[] productExceptSelfI(int[] nums){
        int[] output = new int[nums.length];
        //先求当前元素右边的乘积保存在结果集中；
        int product = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            output[i] = product;
            product *= nums[i];
        }
        //再求左边元素乘积，并直接乘右边元素乘积，保存在结果集中
        product = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = output[i] * product;
            product *= nums[i];
        }
        return output;
    }
}
