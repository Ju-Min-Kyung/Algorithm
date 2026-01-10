import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int number;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String v = br.readLine();
            for (int j = 0; j < N; j++) {
                int c = v.charAt(j) - '0';
                map[i][j] = c;
            }
        }
        calculator(0, 0, N);
        System.out.println(sb.toString());
    }

    public static void calculator(int x, int y, int n) {
        if (n == 0) {
            return;
        }
        boolean isAvailable = true;
        // 모두 같은 번호인지 검증 
        int compared = map[x][y];
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (compared != map[i][j]) {
                    isAvailable = false;
                } 
            }
        }
        
        if (isAvailable) {
            if (compared == 0) {
                sb.append("0");
            }
            else if (compared == 1) {
                sb.append("1");
            }
        }
        else {
            int second = n / 2;
            // 분할 
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    calculator(x + i * second, y + j * second, second);
                }
            }
            sb.append(")");
        }
        
    }
}