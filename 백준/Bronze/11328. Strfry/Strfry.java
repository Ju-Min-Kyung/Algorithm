import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    for (int i = 0; i < N; i++) {
	        int[] alphabet = new int[26];
	        int[] alphabet2 = new int[26];
	        String answer = "Possible";
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        String original = st.nextToken();
	        String newString = st.nextToken();
	        
	        for (char c: original.toCharArray()) {
	            int index = c - 'a';
	            alphabet[index]++;
	        }
	        
	        for (char c: newString.toCharArray()) {
	            int index = c - 'a';
	            alphabet2[index]++;
	        }
	        
	        for (int p = 0; p < 26; p++) {
	            if (alphabet[p] != alphabet2[p]) {
	                answer = "Impossible";
	                break;
	            }
	        }
	        
	        System.out.println(answer);
	    }
	}
}
