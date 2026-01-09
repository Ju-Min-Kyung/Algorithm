import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] visited;
    static char[][] map;
    static int N;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 지도 
        map = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String m = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = m.charAt(j);
            }
        }

        // 적록색약이 아닌 사람 
        int answer1 = 0;
        char[] alphabets = {
            'R',
            'B',
            'G'
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != 1) {
                    bfs(i, j, map[i][j]);
                    answer1++;
                }
            }
        }


        // 적록색약 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        int answer2 = 0;
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != 1) {
                    bfs(i, j, map[i][j]);
                    answer2++;
                }
            }
        }


        System.out.println(answer1 + " " + answer2);

    }

    public static void bfs(int x, int y, char alphabet) {
        Deque < int[] > dq = new ArrayDeque < > ();
        dq.offerLast(new int[] {
            x,
            y
        });
        visited[x][y] = 1;
        int[] dx = {
            1,
            0,
            -1,
            0
        };
        int[] dy = {
            0,
            1,
            0,
            -1
        };

        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && visited[nextX][nextY] != 1 && map[nextX][nextY] == alphabet) {
                    dq.offerLast(new int[] {
                        nextX,
                        nextY
                    });
                    visited[nextX][nextY] = 1;
                }
            }
        }
    }
}