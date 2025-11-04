import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int t = 1; t <= 10; t++) {
            int testNum = Integer.parseInt(bf.readLine());
            int[][] map = new int[100][100];
            boolean[][] visited = new boolean[100][100];
            int answer = 0;

            int startX = 0, startY = 0;

            for (int i = 0; i < 100; i++) {
                String s = bf.readLine().trim();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{startX, startY});
            visited[startX][startY] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
                    if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                    if (map[nx][ny] == 3) {
                        answer = 1;
                        q.clear();
                        break;
                    }

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            System.out.println("#" + testNum + " " + answer);
        }
    }
}
