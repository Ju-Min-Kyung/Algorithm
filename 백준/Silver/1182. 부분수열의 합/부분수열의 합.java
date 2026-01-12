import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, S;
    static int cnt;
    static int sum;
    static int[] arr;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = Integer.parseInt(s.split(" ")[0]);
        S = Integer.parseInt(s.split(" ")[1]);
        arr = new int[N];
        sum = 0;
      
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backTrack(0);
        System.out.println(cnt);
    }

    public static void backTrack(int k) {
        if (k == N) {
            return;
        }

        for (int i = k; i < N; i++) {

            sum += arr[i];
            if (sum == S) {
                cnt++;
            }
            backTrack(i + 1);
            sum -= arr[i];

        }
    }
}