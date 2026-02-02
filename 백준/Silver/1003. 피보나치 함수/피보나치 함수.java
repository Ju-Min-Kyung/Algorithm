import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
		    int n = sc.nextInt();
		    int[][] d = new int[41][2];
		    d[0][0] = 1;
		    d[0][1] = 0;
		    d[1][0] = 0;
		    d[1][1] = 1;
		    for (int j = 2; j <= n; j++) {
		        d[j][0] = d[j-1][0] + d[j-2][0];
		        d[j][1] = d[j-1][1] + d[j-2][1];
		    }
		    
		    System.out.println(d[n][0] + " " + d[n][1]);
		}
	}
}
