import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
		    int n = Integer.parseInt(br.readLine());
		    
		    long[] d = new long[n+1];
		    d[1] = 1;
		    if (n >= 2) d[2] = 1;
		    if( n >= 3) d[3] = 1;
		    
		    for (int i = 4; i <= n; i++) {
		        d[i] = d[i-3] + d[i-2];
		    }
		    
		    System.out.println(d[n]);
		}
	}
}
