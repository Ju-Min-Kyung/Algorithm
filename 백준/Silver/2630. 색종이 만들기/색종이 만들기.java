import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int number;
    static int[][] map;
    static int a, b; // a는 하얀색, b는 파란색
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        calculator(0, 0, N);
        System.out.println(a);
        System.out.println(b);
    }

    public static void calculator(int x, int y, int n) {
        if (n == 0) {
            return;
        }
        boolean isAvailable = true;
        // 모두 같은 색인지 검증
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
                a += 1;
            }
            else if (compared == 1) {
                b += 1;
            }
        }
        else {
            int second = n / 2;
            // 분할 
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    calculator(x + i * second, y + j * second, second);
                }
            }
        }
        
    }
}