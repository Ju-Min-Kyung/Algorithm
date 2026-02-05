import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(b, a); 
        });
        
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i+1) * arr[i] >= max) {
                max = (i+1) * arr[i];
            }
        }
        System.out.println(max);
    }
}