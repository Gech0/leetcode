public class T54_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix ={};
        T54_spiralOrder t = new T54_spiralOrder();
        int[] res = t.spiralOrder(matrix);
        for (int i: res) {
            System.out.print(i + " ");
        }
    }

    /*
    注意：
    1、当low==high, right == left时的边界处理
    2、matrix为空时的处理
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int[] res = new int[(right+1) * (down+1)];
        int index = 0;
        while (index < res.length) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            for (int i = up + 1; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (up!=down)   //这个是为了防止重复计算，如果up==down,则只剩一行了，这行在第一个循环中已经遍历过了，不需要再来一次！
            for (int i = right - 1; i >= left; i--) {
                res[index++] = matrix[down][i];
            }
            if (left!=right)
            for (int i = down - 1; i > up; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }


    /*
    解法2
    思路：把剩下的一行或者一列，单独处理
    出现异常的几种情况：
    1、matrix 是空的
    2、剩下一行、
    3、剩下一列
    4、剩下一个数（可以和上两种情况合并）
     */
    public int[] spiralOrderI(int[][] matrix) {
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res[index++] = matrix[top][i];
            }
            for (int i = top; i < bottom; i++) {
                res[index++] = matrix[i][right];
            }
            for (int i = right; i > left; i--) {
                res[index++] = matrix[bottom][i];
            }
            for (int i = bottom; i > top ; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][left];
            }
        }
        if (top == bottom) {
            for (int i = left; i <= right ; i++) {
                res[index++] = matrix[top][i];
            }
        }
        return res;
    }
}
