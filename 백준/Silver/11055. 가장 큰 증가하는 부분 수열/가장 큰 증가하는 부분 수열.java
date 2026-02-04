import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] d = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
	    
	    
	    for (int i = 1; i <= N; i++) {
	        d[i] = arr[i];
	        for (int j = 1; j < i; j++) {
	            if (arr[i] > arr[j]) { // 증가하는 수열일 경우
	                d[i] = Math.max(d[i], d[j] + arr[i]);
	            }
	        }
	    }
	    
	    int answer = d[1];
	    for (int i = 2; i <= N; i++) {
	        answer = Math.max(answer, d[i]);
	    }
	    
	    System.out.println(answer);
	}
}
