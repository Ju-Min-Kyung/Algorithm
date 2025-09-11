import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        
        int n = firstLine.length();
        int m = secondLine.length();
        int[][] memo = new int[n+1][m+1];
        
        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (firstLine.charAt(i-1) == secondLine.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        
        // 길이 출력
        System.out.println(memo[n][m]);
        
     
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (firstLine.charAt(i-1) == secondLine.charAt(j-1)) {
                sb.append(firstLine.charAt(i-1));
                i--; j--;
            } else if (memo[i-1][j] > memo[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}