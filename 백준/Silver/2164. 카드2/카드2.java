import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    Deque<Integer> cards = new ArrayDeque<>();
	    
	    for (int i = 1; i <= n; i++) {
	        cards.offer(i);
	    }
	    
	    // 카드가 한장 남을 떄까지
	    while (cards.size() > 1) {
	        cards.pop();
	        int second = cards.pop();
	        cards.offer(second);
	    }
	    
	    System.out.println(cards.pop());
	}
}
