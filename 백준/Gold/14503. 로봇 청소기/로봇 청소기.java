import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] map;
 
    static int N, M;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        N = Integer.parseInt(f.split(" ")[0]);
        M = Integer.parseInt(f.split(" ")[1]);

        String s = br.readLine();
        int r = Integer.parseInt(s.split(" ")[0]);
        int c = Integer.parseInt(s.split(" ")[1]);
        int d = Integer.parseInt(s.split(" ")[2]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cx = c;
        int cy = r;
        int cd = d;
        int answer = 0;
        while (true) {
            // 현재 위치가 청소되었는지 파악
            if (map[cy][cx] == 0) {
                map[cy][cx] = 2;
                answer++;
            }
            
            boolean hasCleanArea = false;
            for (int i = 0; i < 4; i++) {
                cd = (cd + 3) % 4;
                
                int nx = cx;
                int ny = cy;
                if (cd == 0) { // 북쪽
                    ny -= 1;
                }
                else if (cd == 1) { // 동쪽
                    nx += 1;
                }
                else if (cd == 2) { // 남쪽 
                    ny += 1; 
                }
                else { // 서쪽
                    nx -= 1;
                }
                
                if (nx >= 0 && ny >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
                    cx = nx;
                    cy = ny;
                    hasCleanArea = true;
                    break;
                }
            }
            
            // 뒤로 이동 
            if (!hasCleanArea) {
                // 어디로 이동할지 
                int dir = (cd + 2) % 4;
                
                if (dir == 0) { // 북쪽
                    cy -= 1;
                }
                else if (dir == 1) { // 동쪽
                    cx += 1;
                }
                else if (dir == 2) { // 남쪽 
                    cy += 1; 
                }
                else { // 서쪽
                    cx -= 1;
                }
                
                if (!(cx >= 0 && cy >= 0 && cy < N && cx < M && map[cy][cx] != 1)) {
                    break;
                }
                
            }
        }
        
        System.out.println(answer);
    }
}