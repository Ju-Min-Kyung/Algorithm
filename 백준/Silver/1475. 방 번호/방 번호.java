import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    // 방 번호
	    String number = br.readLine();
	    // 숫자 count 배열
	    int[] array = new int[10];
	    
	    for (int i = 0; i < number.length(); i++) {
	        int n = (int) number.charAt(i) - '0';
	        array[n]++;
	    }
	    
	    int sum = array[6] + array[9];
	    array[6] = (int) Math.ceil(sum / 2.0);
	    array[9] = (int) Math.ceil(sum / 2.0);
	    
	    int max = 0;
	    
	    for (int i = 0; i < array.length; i++) {
	        max = Math.max(max, array[i]);
	    }
	    
	    System.out.println(max);
	}
}
