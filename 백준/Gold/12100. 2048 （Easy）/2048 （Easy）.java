import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] board;
    static int[][] merged;
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception
    {
        // 입력받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0);
        System.out.println(answer);
    }

    // 백트래킹
    static void backtrack(int k) {
        // 5번 이동할 경우
        if (k == 5) {
            // 가장 큰 블럭 찾기 
            for (int j = 0; j < N; j++) {
                for (int m = 0; m < N; m++) {
                    answer = Math.max(answer, board[j][m]);
                }
            }
            return;
        }

        // 어떤 방향을 선택할 것인가 
        for (int i = 1; i <= 4; i++) {
            merged = new int[N][N];
            int[][] backup = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int m = 0; m < N; m++) {
                    backup[j][m] = board[j][m];
                }
            }
            // 다음 보드판에 들어갈 위치 
            // 위쪽
            if (i == 1) {
                // 열 고정 
                for (int j = 0; j < N; j++) {
                    int target = 0;
                    for (int m = 0; m < N; m++) {
                        if (board[m][j] == 0) {
                            continue;
                        }

                        // 합칠 수 있을 경우 
                        if (target > 0 && board[target - 1][j] == board[m][j] && merged[target - 1][j] == 0) {
                            board[target - 1][j] += board[m][j];
                            board[m][j] = 0;
                            merged[target - 1][j] = 1;
                        }
                        else if (target != m) { // 합칠 수 없을 경우
                            board[target][j] = board[m][j];
                            board[m][j] = 0;
                            target++;
                        }
                        else { // 제자리에 있어도 되는 경우 
                            target++;
                        }
                    }

                }

            }
            else if (i == 2) { // 오른쪽
                for (int m = 0; m < N; m++) {
                    int target = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (board[m][j] == 0) {
                            continue;
                        }

                        if (target < N - 1 && board[m][target + 1] == board[m][j] && merged[m][target + 1] == 0) {
                            board[m][target + 1] += board[m][j];
                            board[m][j] = 0;
                            merged[m][target + 1] = 1;
                        }
                        else if (target != j) { // 합칠 수 없을 경우
                            board[m][target] = board[m][j];
                            board[m][j] = 0;
                            target--;
                        }
                        else {
                            target--;
                        }


                    }
                }
            }
            else if (i == 3) { // 왼쪽
                for (int m = 0; m < N; m++) {
                    int target = 0;
                    for (int j = 0; j < N; j++) {
                        if (board[m][j] == 0) {
                            continue;
                        }


                        // 합칠 수 있을 경우 
                        if (target > 0 && board[m][target - 1] == board[m][j] && merged[m][target - 1] == 0) {
                            board[m][target - 1] += board[m][j];
                            board[m][j] = 0;
                            merged[m][target - 1] = 1;
                        }
                        else if (target != j) { // 합칠 수 없을 경우
                            board[m][target] = board[m][j];
                            board[m][j] = 0;
                            target++;
                        }
                        else {
                            target++;
                        }


                    }
                }
            }
            else { // 아래쪽 
                for (int j = 0; j < N; j++) {
                    int target = N - 1;
                    for (int m = N - 1; m >= 0; m--) {
                        if (board[m][j] == 0) {
                            continue;
                        }


                        // 합칠 수 있을 경우 
                        if (target < N - 1 && board[target + 1][j] == board[m][j] && merged[target + 1][j] == 0) {
                            board[target + 1][j] += board[m][j];
                            board[m][j] = 0;
                            merged[target + 1][j] = 1;
                        }
                        else if (target != m) { // 합칠 수 없을 경우 && 이동해야할 경우 
                            board[target][j] = board[m][j];
                            board[m][j] = 0;
                            target--;
                        }
                        else { // 이동안해도 되는 경우 
                            target--;
                        }

                    }
                }
            }
            backtrack(k + 1);
            // 다시 board 원래대로 
            board = backup;
        }

    }
}