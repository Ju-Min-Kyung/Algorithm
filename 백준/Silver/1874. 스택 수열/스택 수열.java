import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] numbers = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    List<Character> answer = new ArrayList<>();
	    
	    for (int i = 0; i < n; i++) {
	        int k = Integer.parseInt(br.readLine());
	        numbers[i] = k;
	    }
	    
	    int index = 0;
	    int current = 1;
	    while (index < n ) {
	   
	        if (!stack.isEmpty()) {
	            if (numbers[index] == stack.peek()) {
    	            stack.pop();
    	            answer.add('-');
    	            index++;
    	        }
    	        else if (current <= n) {
    	            stack.push(current);
    	            answer.add('+');
    	            current++;
    	        }
    	        else {
    	            System.out.println("NO");
    	            return;
    	        }
	        }
	        else {
	           stack.push(current);
    	       answer.add('+');
    	       current++;
	        }
	    }
	    
	    for (char c: answer) {
	       System.out.println(c);
	   }
	}
}
