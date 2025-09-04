import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
        
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[][] lessons = new int[n][2];
	    for (int i = 0; i<n; i++){
	        lessons[i][0] = sc.nextInt(); // 시작시간
	        lessons[i][1] = sc.nextInt(); // 끝나는 시간
	    }
	    
	    Arrays.sort(lessons, (a, b) -> a[0] - b[0]);
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    pq.add(lessons[0][1]);
	    
	    for (int i = 1; i<n; i++) {
	        if (pq.peek() <= lessons[i][0]) {
	            pq.poll();
	        }
	        pq.add(lessons[i][1]);
	        
	    }
	    System.out.print(pq.size());
	}
}
