import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 돈
        }

        long[] dp = new long[n + 2]; 

        for (int i = 1; i <= n; i++) {

           
            dp[i] = Math.max(dp[i], dp[i - 1]);

          
            int end = i + arr[i][0] - 1;
            if (end <= n) {
                dp[end] = Math.max(dp[end], dp[i - 1] + arr[i][1]);
            }
        }

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
