import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N;
    static char[][] drawMap;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // 삼각형의 변의 개수 
        N = sc.nextInt();
        drawMap = new char[N][N * 2 - 1];

        // ' ' 로 초기화 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                drawMap[i][j] = ' ';
            }
        }

        draw(N, 0, N-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(drawMap[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }

    public static void draw(int n, int x, int y) {
        if (n == 3) {
            for (int i = x; i < x+3; i++) {
                for (int j = y-(i-x); j < y+(i-x)+1; j++) {
                    if (!(i == x+1 && j == y)) {
                        drawMap[i][j] = '*';
                    }
                }
            }
            return;
        }
    
        
        // 분할 
        draw(n/2, x, y);
        draw(n/2, x+n/2, y+n/2);
        draw(n/2, x+n/2, y-n/2);
    }
}