import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int answer = 0;
	    for (int i = 0; i < n; i++) {
	        Deque<Character> dq = new ArrayDeque<>();
	        String s = br.readLine();
	        for (int k = 0; k < s.length(); k++) {
	            char c = s.charAt(k);
	            if (!dq.isEmpty() && dq.peekLast() == c) {
	                dq.pollLast();
	            }
	            else {
	                dq.offerLast(c);
	            }
	        }
	      
	        if (dq.isEmpty()) {
	            answer++;
	        }
	    }
	    
	    System.out.println(answer);

	}
}
