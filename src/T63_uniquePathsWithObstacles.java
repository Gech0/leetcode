public class T63_uniquePathsWithObstacles {
    /*
    测试用例：
    1、只有一个数， {{1}}
    2、矩阵只有一行或一列，且中间含有1
    
     */
    public static void main(String[] args) {
//        int[][] ob = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] ob = {{1,0}};
        System.out.println(uniquePathsWithObstacles(ob));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (row == 0 || col == 0) return 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                if (col == 1) return 0;
            }
            else
                dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                if (row == 1) return 0;
            }
            else
                dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
