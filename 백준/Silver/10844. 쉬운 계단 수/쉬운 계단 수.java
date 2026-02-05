import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long[][] d = new long[101][10];
        
        // 초기값 세팅
        for (int i = 1; i < 10; i++) {
            d[1][i] += 1;
        }
        
        
        int divide = 1000000000;
        // dp 
        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][1] % divide;
            
            for (int j = 1; j <= 8; j++) {
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % divide;
            }
            
            d[i][9] = d[i-1][8] % divide;
        }
        
        //답
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += (d[n][i] % divide);
        }
        System.out.println(answer % divide);
    }
}