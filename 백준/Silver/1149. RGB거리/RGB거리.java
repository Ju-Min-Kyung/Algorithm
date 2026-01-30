import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[1001][4];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[1001][4]; // 누적 점수, 어떤 집인지 
        d[1][1] = cost[1][1];
        d[1][2] = cost[1][2];
        d[1][3] = cost[1][3];
        for (int i = 2; i <= n; i++) {
            d[i][1] = Math.min(d[i-1][2], d[i-1][3]) + cost[i][1];
            d[i][2] = Math.min(d[i-1][1], d[i-1][3]) + cost[i][2];
            d[i][3] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][3];
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            answer = Math.min(answer, d[n][i]);
        }
        
        System.out.println(answer);
    }
}