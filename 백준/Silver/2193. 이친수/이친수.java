import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // N자리 이진수 
		long[][] d = new long[n+1][3]; 
		
		d[1][1] = 1; // 1로 끝나는 숫자
		d[1][2] = 0; // 0으로 끝나는 숫자 
		
		for (int i = 2; i<=n; i++) {
		    // 1 으로 끝나는 숫자
		    d[i][1] = d[i-1][2];
		    // 0으로 끝나는 숫자
		    d[i][2] = (d[i-1][1] + d[i-1][2]);
		}
		
		System.out.println(d[n][1] + d[n][2]);

	}
}
