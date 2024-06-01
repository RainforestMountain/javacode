package test3;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[obstacleGrid.length - 1].length];

        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < dp[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//从障碍物那么走.路径数是0,+ 0不影响结果
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }

    public static void main(String[] args) {
//        int[][] obstacles = {{0, 0, 0},
//                            {0, 1, 0},
//                            {0, 0, 0}};
        int[][] obstacles = new int[][]{{0, 1}};

        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(obstacles));
    }
}
