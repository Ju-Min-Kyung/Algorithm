import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, M;
    static int[] arr;
    static int[] isUsed;
    static StringBuilder sb = new StringBuilder();
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
        arr = new int[13];
        isUsed = new int[13];
        
        backTrack(0);
        System.out.println(sb.toString());
	}
	
	static void backTrack(int k) {
	    if (M == k) {
	        for (int i = 0; i < k; i++) {
	            sb.append(arr[i]).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    
	    for (int i = 1; i <= N; i++) {
	        arr[k] = i;
	        backTrack(k+1);
	       
	    }
	}
}
