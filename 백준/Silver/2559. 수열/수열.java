import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = m-1;
        long sum = 0;
        
        
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        long max = sum;
        
        while (right < arr.length - 1) {
            
            sum -= arr[left++];
            sum += arr[++right];
            if (sum > max) {
                max = sum;
            }
            
        }
        
        System.out.println(max);
	}
}
