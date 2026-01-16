import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static char[][] map;        
    static char[][] arr;       
    static List<int[]> list;

    static int result = Integer.MAX_VALUE;
    static int cctvN = 0;
    static int[][][] cctv;
    static int N, M;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = Integer.parseInt(s.split(" ")[0]);
        M = Integer.parseInt(s.split(" ")[1]);

        map = new char[N][M];
        arr = new char[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0); 
                arr[i][j] = map[i][j];               
            }
        }

        // CCTV 좌표 수집
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '0' && map[i][j] != '6') {
                    list.add(new int[]{i, j});
                    cctvN++;
                }
            }
        }

        cctv = new int[][][] {
            {},
            { {0}, {1}, {2}, {3} },                 // 1번
            { {0,2}, {1,3} },                       // 2번
            { {0,1}, {1,2}, {2,3}, {3,0} },         // 3번
            { {0,1,2}, {1,2,3}, {2,3,0}, {3,0,1} }, // 4번
            { {0,1,2,3} }                           // 5번
        };
        
        backtrack(0);
        System.out.println(result);
    }

    // 회전시키는 함수
    static void backtrack(int k) {
        if (k == cctvN) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == '0') count++;
                    
                }
                
            }
            
            if (result > count) result = count;
            return;
        }

        int[] current = list.get(k);
        int x = current[0];
        int y = current[1];

        int type = map[x][y] - '0';   
        int[][] rotation = cctv[type];
        
        for (int i = 0; i < rotation.length; i++) {
            char[][] backup = new char[N][M];
            // 백업
            for (int m = 0; m < arr.length; m++) {
                for (int n = 0; n < arr[0].length; n++) {
                    backup[m][n] = arr[m][n];
                }
            }
            for (int j = 0; j < rotation[i].length; j++) {

                int dir = rotation[i][j];
                
                // 0 = 위
                if (dir == 0) {
                    for (int p = x - 1; p >= 0; p--) {
                        if (map[p][y] == '6') break;
                        if (arr[p][y] == '0') arr[p][y] = '#';
                    }
                }
                // 1 = 오른쪽
                else if (dir == 1) {
                    for (int p = y + 1; p < arr[0].length; p++) {
                        if (map[x][p] == '6') break;
                        if (arr[x][p] == '0') arr[x][p] = '#';
                    }
                }
                // 2 = 아래
                else if (dir == 2) {
                    for (int p = x + 1; p < arr.length; p++) {
                        if (map[p][y] == '6') break;
                        if (arr[p][y] == '0') arr[p][y] = '#';
                    }
                }
                // 3 = 왼쪽
                else {
                    for (int p = y - 1; p >= 0; p--) {
                        if (map[x][p] == '6') break;
                        if (arr[x][p] == '0') arr[x][p] = '#';
                    }
                }
            }

            backtrack(k + 1);
            arr = backup;
            
        }
    }
}
