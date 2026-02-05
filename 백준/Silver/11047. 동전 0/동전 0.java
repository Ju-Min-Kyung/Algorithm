import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            arr[i] = c;
        }
        
        int sum = 0;
        int answer = 0;
        int index = arr.length - 1;
        
        for (int i = index; i >= 0; i--) {
            if (k == sum ){
                break;
            }
            
            while (sum + arr[i] <= k) {
                sum += arr[i];
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}