import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] memo = new int[n][n];

        memo[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j > 0) {
                    memo[i][j] = Math.max(memo[i][j], memo[i-1][j-1] + triangle[i][j]);
                }
                if (j < triangle[i-1].length) {
                    memo[i][j] = Math.max(memo[i][j], memo[i-1][j] + triangle[i][j]);
                }
            }
        }
        
        return Arrays.stream(memo[n-1]).max().getAsInt();
    }
}
