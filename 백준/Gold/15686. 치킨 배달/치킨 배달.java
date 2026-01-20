import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static List < int[] > home;
    static List < int[] > chicken;
    static int M;
    static int[][] survived;
    static int[] distance;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]); // 행의 개수
        M = Integer.parseInt(s.split(" ")[1]); // 열의 개수 

        home = new ArrayList < > ();
        chicken = new ArrayList < > ();
        survived = new int[M][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                // 집일 경우 
                if (value == 1) {
                    home.add(new int[] {
                        i,
                        j
                    });
                }
                else if (value == 2) { // 치킨집일 경우 
                    chicken.add(new int[] {
                        i,
                        j
                    });
                }

            }
        }

        backtrack(0, 0);

        System.out.println(answer);

    }

    public static void backtrack(int k, int p) {
        if (k == M) {
            distance = new int[home.size()];
            for (int i = 0; i < distance.length; i++) {
                distance[i] = 1000000;
            }
            // 최소 치킨 거리 갱신
            for (int i = 0; i < survived.length; i++) {
                int[] chi = survived[i];
               
                for (int j = 0; j < home.size(); j++) {
                    int[] ho = home.get(j);
                   
                    distance[j] = Math.min(Math.abs(ho[0] - chi[0]) + Math.abs(ho[1] - chi[1]), distance[j]);
                   
                }
            }

            int value = 0;
            for (int i = 0; i < distance.length; i++) {
                value += distance[i];
            }

            answer = Math.min(value, answer);
            return;
        }

        // 치킨집 선택 
        for (int i = p; i < chicken.size(); i++) {
            // 선택한 치킨집 저장
            survived[k] = chicken.get(i);
            backtrack(k + 1, i + 1);
        }
    }

}