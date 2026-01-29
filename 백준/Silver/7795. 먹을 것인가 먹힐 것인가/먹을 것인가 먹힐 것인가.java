import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int N = Integer.parseInt(s.split(" ")[0]);
            int M = Integer.parseInt(s.split(" ")[1]);
            
            Integer[] A = new Integer[N];
            Integer[] B = new Integer[M];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st2.nextToken());
            }
            
            Arrays.sort(A, Collections.reverseOrder());
            Arrays.sort(B, Collections.reverseOrder());
            int answer = 0;
            int idx = 0;
            for (int i = 0; i < A.length; i++) {
                int a = A[i];
                for (int j = idx; j < B.length; j++) {
                    if (B[j] < a) {
                        answer += (M-j);
                        idx = j;
                        break;
                    }
                }
                
                if (a <= B[idx]) {
                    break;
                }
                
            }
            
            System.out.println(answer);
        }
    }
}