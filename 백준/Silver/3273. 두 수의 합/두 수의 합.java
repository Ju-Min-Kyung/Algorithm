import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        
        int x = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        int i = 0; 
        int j = array.length - 1;
        
        while (i < j) {
            if (array[i] + array[j] == x) {
                answer++;
                i++;
                j--;
            }
            else if (array[i] + array[j] < x) {
                i++;
            }
            else {
                j--;
            }
        }
        
        System.out.println(answer);
	}
}
