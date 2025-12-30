import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    Deque<Integer> dq = new ArrayDeque<>();
	    
	    for (int i = 0; i < n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        if (st.countTokens() == 1) {
	            switch (st.nextToken()) {
	               case "pop":
	                   System.out.println(dq.isEmpty() ? "-1" : dq.poll());     
	                   break;
	               case "size":
	                   System.out.println(dq.size());
	                   break;
	               case "empty":
	                   System.out.println(dq.isEmpty() ? "1" : "0");
	                   break;
	               case "back":
	                   System.out.println(dq.isEmpty() ? "-1" : dq.peekLast());
	                   break;
	               case "front":
	                   System.out.println(dq.isEmpty() ? "-1" : dq.peekFirst());
	                   break;
	            }
	        }
	        else {
	            String command = st.nextToken();
	        
	            int num = Integer.parseInt(st.nextToken());
	            
	            dq.offer(num);
	        }
	    }
	}
}
