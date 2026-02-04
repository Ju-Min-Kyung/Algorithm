import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[1001][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 돈
        }

        long[][] d = new long[1001][2];
        

        for (int i = 1; i <= n; i++) {

        
            d[i][1] = Math.max(d[i][1], d[i - 1][1]);

            int end = i + arr[i][0] - 1; // 상담이 끝나는 날

           
            if (end <= n) {
                d[end][1] = Math.max(d[end][1], d[i - 1][1] + arr[i][1]);
            }
        }

      
        long answer = d[n][1];
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d[i][1]);
        }

        System.out.println(answer);
    }
}
