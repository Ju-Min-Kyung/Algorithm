import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static int[][] visited;
    public static int[][] graph;
    static int n;
    static int m;
    static Deque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        m = Integer.parseInt(s.split(" ")[0]);
        n = Integer.parseInt(s.split(" ")[1]);
        
        graph = new int[n][m];
        
        // 그래프 만들기 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int j = 0; j < size; j++) {
                int v = Integer.parseInt(st.nextToken());
                graph[i][j] = v;
            }
            
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    q.offerLast(new int[]{i, j});
                    
                }
            }
        }
        
        bfs();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                else {
                    answer = Math.max(answer, graph[i][j]);
                }
            }
        }
        
        System.out.println(answer-1);
        
    }
    
    public static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while (!q.isEmpty()) {
            int[] start = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = start[0] + dx[i];
                int ny = start[1] + dy[i];
            
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 0) {
                    q.offerLast(new int[]{nx, ny});
                    graph[nx][ny] = graph[start[0]][start[1]] + 1;
                }
            }
        }
    }
}