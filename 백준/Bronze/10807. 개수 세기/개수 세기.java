import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    // N 자연수 개수
	    int N = Integer.parseInt(br.readLine());
	    // 정수
	    String numbers = br.readLine();
	    String[] array = numbers.split(" ");
	    // count;
	    int[] count = new int[201];
	   
	    for (int i = 0; i < array.length; i++) {
	        int index = Integer.parseInt(array[i]) + 100;
	        count[index]++;
	    }
	    
	    int V = Integer.parseInt(br.readLine());
	    System.out.println(count[V+100]);
	}
}
