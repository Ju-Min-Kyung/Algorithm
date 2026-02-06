import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int T = Integer.parseInt(s.split(" ")[0]);
		int W = Integer.parseInt(s.split(" ")[1]);
		
		int[] arr = new int[T+1]; // 사과의 위치
		int[][] dp = new int[T+1][W+1]; // T초만큼, W 번 움직였을 떄, 먹을 수 있는 사과의 최대 개수 
		
		for (int i = 1; i <= T; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}
		
	
		for (int i = 1; i <= T; i++) {
		    for (int j = 0; j <= W; j++) {
		        
		        int pos = (j % 2 == 0) ? 1 : 2;
		        int gain = (arr[i] == pos) ? 1 : 0;
		        
		        // 이동 안함 
		        dp[i][j] = dp[i-1][j] + gain;
		        
		        // 이동 함 
		        if (j > 0) {
		            dp[i][j] = Math.max(dp[i-1][j-1] + gain, dp[i][j]);
		        }
		    }
		}
		
		int ans = 0;
        for (int j = 0; j <= W; j++) {
            ans = Math.max(ans, dp[T][j]);
        }

        System.out.println(ans);
	}
}
