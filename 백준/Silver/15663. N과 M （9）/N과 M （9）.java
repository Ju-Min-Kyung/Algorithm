import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, M;
    static int[] arr;
    static int[] isUsed;
    static int[] input;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        arr = new int[N];
        isUsed = new int[N];
       
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
            
        Arrays.sort(input);
        backTrack(0, -1);
        System.out.println(sb.toString());
    }

    static void backTrack(int k, int p) {
        if (M == k) {
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (input[i] == prev) continue;
            if (isUsed[i] == 0) {
                arr[k] = input[i];
                isUsed[i] = 1;
                prev = input[i];
                backTrack(k + 1, i);
                isUsed[i] = 0;
            }
        }
    }
}