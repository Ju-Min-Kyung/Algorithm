import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[n+1];
		
		d[1] = 1;
		if (n >= 2) d[2] = 3;
		
		for (int i = 3; i <= n; i++) {
		    d[i] = ( d[i-1] + d[i-2] * 2 ) % 10007;
		}
        
        System.out.println(d[n]);
	}
}
