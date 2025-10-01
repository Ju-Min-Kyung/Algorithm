import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
		    int t = sc.nextInt();
		    if (t == 0 ) {
		        int value = Optional.ofNullable(pq.poll()).orElse(0);
		        System.out.println(value);
		    }
		    else {
		        pq.add(t);
		    }
		}

	}
}
