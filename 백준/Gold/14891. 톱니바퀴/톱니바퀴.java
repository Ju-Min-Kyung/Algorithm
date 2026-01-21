import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        String[] wheels = new String[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            wheels[i] = s;
        }

        // 바퀴 양쪽에 있는 인덱스를 저장하는 배열 
        int[][] wheelInfo = new int[4][2];
        for (int i = 0; i < 4; i++) {
            // 초기화 
            wheelInfo[i][0] = 6; // 9시 방향
            wheelInfo[i][1] = 2; // 3시 방향 
        }

        // 회전 수 입력받기 
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int d = Integer.parseInt(s.split(" ")[1]);

            input[i][0] = n;
            input[i][1] = d;
        }

        int[] rotate = {
            0,
            0,
            0,
            0
        };

        for (int i = 0; i < input.length; i++) {
            // 회전할 바퀴 (input)
            int wheel = input[i][0] - 1;
            int dir = input[i][1];
            rotate = new int[4];
            // 바퀴 방향 
            rotate[wheel] = dir;
            // 각 섹션의 맞닿은 극 검사 (극이 다를 때, true)
            boolean[] section = new boolean[3];

            // 섹션 검사 
            if (wheels[0].charAt(wheelInfo[0][1]) !=
                wheels[1].charAt(wheelInfo[1][0])) {
                section[0] = true;
            }

            if (wheels[1].charAt(wheelInfo[1][1]) !=
                wheels[2].charAt(wheelInfo[2][0])) {
                section[1] = true;
            }

            if (wheels[2].charAt(wheelInfo[2][1]) !=
                wheels[3].charAt(wheelInfo[3][0])) {
                section[2] = true;
            }

            // 왼쪽 전파 
            for (int j = wheel; j > 0; j--) {
                if (section[j - 1]) {
                    rotate[j - 1] = -rotate[j];
                }
                else {
                    break;
                }
            }

            // 오른쪽 전파
            for (int j = wheel; j < 3; j++) {
                if (section[j]) {
                    rotate[j + 1] = -rotate[j];
                }
                else {
                    break;
                }
            }

            for (int r = 0; r < 4; r++) {
                if (rotate[r] == -1) { // 반시계 방향 
                    wheelInfo[r][0] += 1;
                    wheelInfo[r][1] += 1;
                }
                else if (rotate[r] == 1) { // 시계방향
                    wheelInfo[r][0] -= 1;
                    wheelInfo[r][1] -= 1;
                }

                wheelInfo[r][0] = (wheelInfo[r][0] + 8) % 8;
                wheelInfo[r][1] = (wheelInfo[r][1] + 8) % 8;
            }
        }

        int weight = 1;
        int answer = 0;
        // 점수 계산 
        for (int i = 0; i < 4; i++) {
            int index = (wheelInfo[i][0] + 2) % 8;

            if (wheels[i].charAt(index) == '1') {
                answer += weight;
            }
            weight *= 2;
        }

        System.out.println(answer);
    }
}