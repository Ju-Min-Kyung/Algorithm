import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][][] map;
    static int[][][] dist;
    static int M, N, K;
    static Deque < int[] > dq = new ArrayDeque < > ();

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        M = Integer.parseInt(s.split(" ")[0]);
        N = Integer.parseInt(s.split(" ")[1]);
        K = Integer.parseInt(s.split(" ")[2]);

        map = new int[K][N][M];
        dist = new int[K][N][M];

        for (int z = 0; z < K; z++) {
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 익은 토마토 찾기 
        for (int k = 0; k < K; k++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[k][n][m] == 1) {
                        dq.offerLast(new int[] {
                            k,
                            n,
                            m
                        });
                    }
                }
            }
        }

        // bfs
        bfs();

        // 답 구하기 
        int answer = 0;
        for (int k = 0; k < K; k++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    answer = Math.max(answer, dist[k][n][m]);
                    if (map[k][n][m] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs() {
        int[] dx = {
            -1,
            0,
            1,
            0,
            0,
            0
        };
        int[] dy = {
            0,
            1,
            0,
            -1,
            0,
            0
        };
        int[] dz = {
            0,
            0,
            0,
            0,
            1,
            -1
        };

        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();

            for (int i = 0; i < 6; i++) {
                int nextZ = current[0] + dz[i];
                int nextY = current[1] + dy[i];
                int nextX = current[2] + dx[i];

                if (nextZ >= 0 && nextZ < K && nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextZ][nextY][nextX] == 0) {
                    dq.offerLast(new int[] {
                        nextZ,
                        nextY,
                        nextX
                    });
                    dist[nextZ][nextY][nextX] = dist[current[0]][current[1]][current[2]] + 1;
                    map[nextZ][nextY][nextX] = 1;
                }
            }
        }
    }
}