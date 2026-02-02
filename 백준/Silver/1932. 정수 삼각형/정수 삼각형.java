import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n][n]; // 삼각형
        int[][] d = new int[n][n]; // DP

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d[0][0] = tri[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) { // 왼쪽 끝
                    d[i][j] = d[i - 1][j] + tri[i][j];
                }
                else if (j == i) {
                    d[i][j] = d[i - 1][j - 1] + tri[i][j];
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + tri[i][j];
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, d[n - 1][j]);
        }
        System.out.println(answer);
    }
}