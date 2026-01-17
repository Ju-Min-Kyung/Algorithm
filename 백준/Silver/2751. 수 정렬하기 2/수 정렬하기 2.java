import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
		    int m = Integer.parseInt(br.readLine());
		    array[i] = m;
		}
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
		    sb.append(array[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
