import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static int[][] visited;
    public static int[][] graph;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);
        visited = new int[n][m];
        graph = new int[n][m];
        
        // graph 입력받기
        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int j = 0; j < size; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i][j] = 1;
                }
            }
        }
        
        int count = 0;
        int answer = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && graph[i][j] == 1) {
                    int num = bfs(i, j);
                    answer = Math.max(num, answer);
                    count++;
                }
            }
        }
        
        System.out.println(count);
        System.out.println(answer);
        
    }
    
    // visited 방문 처리 
    public static int bfs(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{x,y});
        visited[x][y] = 1;
        int area = 1;
        
        while (!q.isEmpty()) {
            int[] start = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = start[0] + dx[i];
                int ny = start[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.offerLast(new int[]{nx, ny});
                    area++;
                }
            }
        }
        return area;
    }
    
}