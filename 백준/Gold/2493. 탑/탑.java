import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] answer = new int[n];
	    int[] input = new int[n];
	    Deque<Integer> dq = new ArrayDeque<>();
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
	    while (st.hasMoreTokens()) {
            input[index] = Integer.parseInt(st.nextToken());
            index++;
	    }
	    
	    // 현재 갱신할 탑 위치 
	   
	    for (int i = input.length-1; i >= 0; i--) {
	        int nowTop = input[i];
	        
	        while (!dq.isEmpty() && input[dq.peek()] < nowTop) {
	            int idx = dq.pop();
                answer[idx] = i + 1;
	        }
	        
	        dq.push (i);
	    }
	    
	    for (int an: answer) {
	        System.out.print(an + " ");
	    }
	}
}
