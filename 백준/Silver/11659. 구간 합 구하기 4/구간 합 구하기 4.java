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
        int m = Integer.parseInt(s.split(" ")[1]);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[100001];
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] d = new int[100001];
        d[1] = input[1];
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + input[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String k = br.readLine();
            int first = Integer.parseInt(k.split(" ")[0]);
            int second = Integer.parseInt(k.split(" ")[1]);
            
            sb.append(d[second] - d[first-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}