import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String N = br.readLine();
	    List<Character> list = new LinkedList<>();
	    
	    for (int n = 0; n < N.length(); n++) {
	        list.add(N.charAt(n));
	    }
	    
	    int k = Integer.parseInt(br.readLine());
	    ListIterator<Character> cursor = list.listIterator(list.size());
	    // k번
	    for (int i = 0; i < k; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        if (st.countTokens() > 1) {
	            String command = st.nextToken();
	            char c = st.nextToken().charAt(0);
	            cursor.add(c);
	        }
	        else {
	            char c = st.nextToken().charAt(0);
	            if (c == 'L') {
	                if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
	            }
	            else if (c == 'D') {
	                if (cursor.hasNext()) {
                        cursor.next();
                    }
	            }
	            else {
	                if (cursor.hasPrevious()) {
	                    cursor.previous();
	                    cursor.remove();
	                }
	            }
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (Character c: list) {
	        sb.append(c);
	    }
	    System.out.println(sb.toString());
	}
}
