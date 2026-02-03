import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] d = new long[n+1];
		d[1] = arr[1];
		
		for (int i = 2; i <= n; i++) {
		    if (d[i-1] + arr[i] > arr[i]) {
		        d[i] = d[i-1] + arr[i];
		    }
		    else {
		        d[i] = arr[i];
		    }
		}
		
		long answer = d[1];
		for (int i = 1; i <= n; i++) {
		    answer = Math.max(answer, d[i]);   
		}
		
		System.out.println(answer);

	}
}
