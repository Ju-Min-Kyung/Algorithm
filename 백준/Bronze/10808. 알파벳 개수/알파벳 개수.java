import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String word = br.readLine();
	    int[] answer = new int[26];
	    for (int i = 0; i < word.length(); i++) {
	        int index = word.charAt(i) - 'a';
	        answer[index]++;
	    }
	    
	    for (int a: answer) {
	        System.out.print(a + " ");
	    }

	}
}
