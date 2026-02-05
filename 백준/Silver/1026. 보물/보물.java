import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(B);
        Arrays.sort(A);
        reverse(A);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (A[i] * B[i]);
        }
        System.out.println(answer);
    }
    
    static int[] reverse(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}