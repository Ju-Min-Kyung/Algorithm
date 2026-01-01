import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s = br.readLine();
	    Deque<Character> dq = new ArrayDeque<>();
	    int answer = 0;
	    char previous = '(';
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') {
	            dq.offerLast(c);
	        }    
	        else {
	            dq.pollLast();
	            if (previous == '(') {
	                answer += dq.size();
	            }
	            else {
	                answer += 1;   
	            }
	        }
	        
	        previous = c;
	    }
        
        System.out.println(answer);
	}
}
