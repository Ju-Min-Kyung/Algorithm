import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] d = new int[n + 1];
            if (n >= 1) d[1] = 1;
            if (n >= 2) d[2] = 2;
            if (n >= 3) d[3] = 4;

            for (int i = 4; i <= n; i++) {
                d[i] = d[i - 3] + d[i - 2] + d[i - 1];
            }
            System.out.println(d[n]);
        }
    }
}