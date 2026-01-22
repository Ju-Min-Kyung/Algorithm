import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[] dice1; // 남북 주사위 번호 저장 
    static int[] dice2;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]); // 행의 개수 
        int M = Integer.parseInt(s.split(" ")[1]); // 열의 개수 
        int x = Integer.parseInt(s.split(" ")[2]); // 시작 좌표 
        int y = Integer.parseInt(s.split(" ")[3]);
        int K = Integer.parseInt(s.split(" ")[4]); // 명령의 개수 

        // 지도 입력받기 
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령 입력받기 
        int[] command = new int[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        };

        dice1 = new int[]{0, 0, 0, 0}; // 위, 북, 남, 아래 
        dice2 = new int[]{0, 0, 0, 0}; // 위, 동, 서, 아래 
        int[] current = new int[] {
            x,
            y
        };

        // 명령 수행 
        for (int i = 0; i < command.length; i++) {
            // 명령 
            int c = command[i];
            int nx = current[0];
            int ny = current[1];
            if (c == 1) {
                ny += 1;
            }
            else if (c == 2) {
                ny -= 1;
            }
            else if (c == 3) { 
                nx -= 1;
            }
            else {
                nx += 1;
            }

            if (ny >= 0 && nx >= 0 && ny < M && nx < N) {
                // 현재 위치 갱신 
                current[0] = nx;
                current[1] = ny;
              
                
                // 주사위 움직이기 
                moveDice(c);

                // 지도에 쓰여 있는 수가 0이 아닐 때, 주사위의 바닥면에 복사 
                if (map[current[0]][current[1]] != 0) {
                    dice1[3] = map[current[0]][current[1]];
                    dice2[3] = map[current[0]][current[1]];
                    map[current[0]][current[1]] = 0;
                }
                else { // 0일 때, 주사위의 바닥면이 칸에 복사  
                    map[current[0]][current[1]] = dice1[3];
                }
                
                System.out.println(dice1[0]);
            }
        }
    }

    public static void moveDice(int type) {
        int[] backup1 = new int[4];
        int[] backup2 = new int[4];
        for (int i = 0; i < 4; i++) {
            backup1[i] = dice1[i];
            backup2[i] = dice2[i];
        }

        if (type == 1) { // 동
            dice2[0] = backup2[2];
            dice2[1] = backup2[0];
            dice2[2] = backup2[3];
            dice2[3] = backup2[1];
            dice1[0] = dice2[0];
            dice1[3] = dice2[3];
        }
        else if (type == 2) { // 서
            dice2[0] = backup2[1];
            dice2[1] = backup2[3];
            dice2[2] = backup2[0];
            dice2[3] = backup2[2];
            dice1[0] = dice2[0];
            dice1[3] = dice2[3];
        }
        else if (type == 3) { // 북 
            dice1[0] = backup1[2];
            dice1[1] = backup1[0];
            dice1[2] = backup1[3];
            dice1[3] = backup1[1];
            dice2[0] = dice1[0];
            dice2[3] = dice1[3];
        }
        else { // 남 
            dice1[0] = backup1[1];
            dice1[1] = backup1[3];
            dice1[2] = backup1[0];
            dice1[3] = backup1[2];
            dice2[0] = dice1[0];
            dice2[3] = dice1[3];
        }
    }
}