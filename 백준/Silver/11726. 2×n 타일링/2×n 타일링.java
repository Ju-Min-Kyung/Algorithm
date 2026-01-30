import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        
        d[1] = 1;
        d[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-2] + d[i-1]) % 10007;
        }
        System.out.println(d[n]);
    }
}