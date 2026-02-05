import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            long start = Integer.parseInt(s.split(" ")[0]);
            long end = Integer.parseInt(s.split(" ")[1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        // 끝나는 시간이 작고 
        Arrays.sort(arr, (a, b) -> {
            if (Long.compare(a[1], b[1]) == 0) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int answer = 0;
        long end = 0;
        for (int i = 0; i < n; i++) {
            if (end <= arr[i][0]) { // 끝나는 시간보다 시작 시간이 더 크면 
             
                end = arr[i][1];
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}