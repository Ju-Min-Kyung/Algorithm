import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static int[] memo;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    int N = Integer.parseInt(br.readLine());
	    List<int[]> inputs = new ArrayList<>();
	    memo = new int[N+1];
	    
	    for (int i=0; i < N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        inputs.add(new int[]{a, b});
	        
	    }
	    
	    for (int i = 0; i < N; i++) {
	        if (i > 0) memo[i] = Math.max(memo[i], memo[i-1]);
	        int t = inputs.get(i)[0];
            int p = inputs.get(i)[1];

            int endDay = i + t - 1; 
            if (endDay < N) {
                memo[endDay] = Math.max(memo[endDay], p + (i > 0 ? memo[i-1] : 0));
            }
	        
	    }
	    System.out.println(memo[N-1]);
	}
}
