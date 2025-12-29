import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    long number = 1;
	    for (int i = 0; i < 3; i++) {
	        number *= Long.parseLong(br.readLine());
	    }
	    
	    int index = 0;
	    int[] answer = new int[10];
	    String numberStr = String.valueOf(number);
	    for (int i = 0; i < numberStr.length(); i++) {
	        index = (int) numberStr.charAt(i) - '0';
	        answer[index]++;
	    }
	    
	    for (int i = 0; i < answer.length; i++) {
	        System.out.println(answer[i]);
	    }
	}
}
