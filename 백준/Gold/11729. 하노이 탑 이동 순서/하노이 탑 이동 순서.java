import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long count = (1L << n) - 1;
        sb.append(count).append('\n');

        hanoi(1, 3, n);

        System.out.print(sb.toString());
    }

    public static void hanoi(int a, int b, int n) {
        if (n == 0) return;

        int c = 6 - a - b;

        hanoi(a, c, n - 1);
        sb.append(a).append(' ').append(b).append('\n');
        hanoi(c, b, n - 1);
    }
}
