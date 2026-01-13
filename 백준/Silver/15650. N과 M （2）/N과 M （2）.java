import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, M;
    static int[] arr;
    static int[] isUsed;
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
        arr = new int[10];
        isUsed = new int[10];
        
        backTrack(0, 0);
	}
	
	static void backTrack(int k, int p) {
	    if (M == k) {
	        for (int i = 0; i < k; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	    
	    for (int i = p+1; i <= N; i++) {
	        if (isUsed[i] == 0) {
	            isUsed[i] = 1;
	            arr[k] = i;
	            backTrack(k+1, i);
	            isUsed[i] = 0;
	        }
	    }
	}
}
