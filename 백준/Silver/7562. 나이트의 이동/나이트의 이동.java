import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] dist;
    static int[][] map;
    static int I;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            dist = new int[I][I];
            
            int[] depart = new int[2];
            int[] arrival = new int[2];
            
            String first = br.readLine();
            depart[0] = Integer.parseInt(first.split(" ")[0]);
            depart[1] = Integer.parseInt(first.split(" ")[1]);
            
            String second = br.readLine();
            arrival[0] = Integer.parseInt(second.split(" ")[0]);
            arrival[1] = Integer.parseInt(second.split(" ")[1]);
            bfs(depart, arrival);
        }

    }

    public static void bfs(int[] depart, int[] arrival) {
        Deque < int[] > dq = new ArrayDeque < > ();
        dq.offerLast(depart);
        dist[depart[0]][depart[1]] = 1;
        int[] dx = {2, 1, -1, -2, -1, 1, 2, -2};
        int[] dy = {1, 2, -2, -1, 2, -2, -1, 1};

        while (!dq.isEmpty()) {
            int[] current = dq.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX >= 0 && nextX < I && nextY >= 0 && nextY < I && dist[nextX][nextY] == 0) {
                    dq.offerLast(new int[] {
                        nextX,
                        nextY
                    });
                    dist[nextX][nextY] = dist[current[0]][current[1]] + 1;
                }
                
                if (nextX == arrival[0] && nextY == arrival[1]) {
                    System.out.println(dist[nextX][nextY] - 1);
                    return;
                }
            }
        }
    }
}