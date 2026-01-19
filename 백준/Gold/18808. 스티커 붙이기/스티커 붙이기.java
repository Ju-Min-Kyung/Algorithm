import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        // 입력받기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 세로 길이 
        int N = Integer.parseInt(s.split(" ")[0]);
        // 가로 길이
        int M = Integer.parseInt(s.split(" ")[1]);
        // 스티커 개수 
        int K = Integer.parseInt(s.split(" ")[2]);

        // 스티커 저장할 배열 
        int[][][] sticker = new int[K][10][10];
        // 스티커 사이즈 저장할 배열 
        int[][] sizes = new int[K][2];

        for (int i = 0; i < K; i++) {
            // 스티커 가로 세로 길이
            String sti = br.readLine();
            int r = Integer.parseInt(sti.split(" ")[0]);
            int c = Integer.parseInt(sti.split(" ")[1]);
            sizes[i] = new int[] {
                r,
                c
            };
            for (int j = 0; j < r; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int m = 0; m < c; m++) {
                    sticker[i][j][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 노트북 배열 
        int[][] notebook = new int[N][M];
        // 회전 타입 
        int type = 1;

        // 노트북에 스티커 붙이기 
        for (int i = 0; i < K; i++) {
            int[][] current = sticker[i];
            for (int t = 0; t < 4; t++) {
                // 현재 스티커 
                int r = sizes[i][0]; // 행
                int c = sizes[i][1]; // 열

                int stickerW = 0;
                int stickerH = 0;
                boolean isAvailabe = true;

                if (r <= N && c <= M) {
                    outer: for (int w = 0; w <= N - r; w++) {
                        for (int h = 0; h <= M - c; h++) {
                            isAvailabe = true;

                            inner:
                                for (int sw = 0; sw < r; sw++) {
                                    for (int sh = 0; sh < c; sh++) {
                                        if (current[sw][sh] == 1 && notebook[w + sw][h + sh] == 1) {
                                            isAvailabe = false;

                                            break inner;
                                        }
                                    }
                                }

                            if (isAvailabe) {
                                stickerW = w;
                                stickerH = h;
                                break outer;
                            }
                        }
                    }

                    if (isAvailabe) {
                        for (int sw = 0; sw < r; sw++) {
                            for (int sh = 0; sh < c; sh++) {
                                if (current[sw][sh] == 1) {
                                    notebook[stickerW + sw][stickerH + sh] = 1;
                                }
                            }
                        }
                        break;
                    }
                }

                // 90도 회전
                current = rotateSticker(current, r, c);
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        int answer = 0;
        // 노트북 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                
                if (notebook[i][j] == 1) {
                    answer++;
                }
            }
         
        }

        System.out.println(answer);
    }

    // 스티커 회전시키는 함수
    static int[][] rotateSticker(int[][] sticker, int r, int c) {
        int[][] rotated = new int[10][10];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotated[j][r - i - 1] = sticker[i][j];
            }
        }

        return rotated;
    }
}