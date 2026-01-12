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
        N = sc.nextInt();
        drawMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                drawMap[i][j] = '*';
            }
        }
        draw(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(drawMap[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void draw(int n, int x, int y) {
        if (n < 3) {
            return;
        }
        
        int step = n / 3;
        
        // 공백으로 채우기 
        for (int i = x + step; i < x+ 2*step; i++) {
            for (int j = y + step; j < y+ 2*step; j++) {
                drawMap[i][j] = ' ';
            }
        }
        
        // 재귀 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    draw(n / 3, x + i * step, y + j * step);
                } 
            }
        }

    }
}