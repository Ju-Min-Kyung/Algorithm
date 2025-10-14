import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += arr[i];
        }

        long maxSum = currentSum;

        for (int i = m; i < n; i++) {
            currentSum += arr[i] - arr[i - m];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
