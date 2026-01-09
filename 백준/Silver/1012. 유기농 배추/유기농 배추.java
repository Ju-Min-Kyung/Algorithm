import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] visited;
    static int[][] map;
    static int M;
    static int N;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();

            M = Integer.parseInt(s.split(" ")[0]); // 가로 (열)
            N = Integer.parseInt(s.split(" ")[1]); // 세로 (행)
            int K = Integer.parseInt(s.split(" ")[2]); // 배추의 개수 
            
            // 배추 지도 
            map = new int[N][M];
            visited = new int[N][M];
            
            for (int i = 0; i < K; i++) {
                String m = br.readLine();
                int y = Integer.parseInt(m.split(" ")[0]);
                int x = Integer.parseInt(m.split(" ")[1]);
                
                map[x][y] = 1;
            }
            
            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] != 1 && map[i][j] == 1) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

    }
    
    public static void bfs(int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{x, y});
        visited[x][y] = 1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && visited[nextX][nextY] != 1 && map[nextX][nextY] == 1) {
                    dq.offerLast(new int[]{nextX, nextY});
                    visited[nextX][nextY] = 1;
                } 
            }
        }
    }
}