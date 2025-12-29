import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String first = br.readLine();
	    String second = br.readLine();
	    int[] alphabet = new int[26];
	    int[] alphabet2 = new int[26];
	    int answer = 0;
	    
	    for (char c: first.toCharArray()) {
	        int index = c - 'a';
	        alphabet[index]++;
	    }
	    
	    for (char c: second.toCharArray()) {
	        int index = c - 'a';
	        alphabet2[index]++;
	    }
	    
	    for (int i = 0; i < alphabet.length; i++) {
	        if (alphabet[i] != alphabet2[i]) {
	            if (alphabet[i] != 0 && alphabet2[i] != 0) {
	                int min = Math.min(alphabet[i], alphabet2[i]);
	                int max = Math.max(alphabet[i], alphabet2[i]);
	                answer += (max-min);
	            }
	            else {
	                answer += alphabet[i];
	                answer += alphabet2[i];
	            }
	        }
	    }
	    
	    System.out.println(answer);
	}
}
