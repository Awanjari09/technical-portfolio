package Problems;
import java.util.*;

public class LongestIncreasingPath {
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] != 0)
            return dp[i][j];
        int maxLength = 1;
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                int length = 1 + dfs(matrix, dp, x, y);
                maxLength = Math.max(maxLength, length);
            }
        }
        dp[i][j] = maxLength;
        return maxLength;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, dp, i, j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int result = longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path Length: " + result);
    }
}
