import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int[][] input = new int[10][2];
    static int[][] egg = new int[10][2];
    static int result = 0;
    static int N; // 달걀의 개수
    static int liveN; // 깨지지 않은 달걀의 개수 

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
       
        for (int i = 0; i < N; i++) {
            int dur = sc.nextInt(); // 내구도
            int weight = sc.nextInt();

            input[i][0] = dur;
            input[i][1] = weight;
            
            egg[i][0] = dur;
            egg[i][1] = weight;
        }
        
        backtrack(0);
        System.out.println(result);
    }

    // 어떤 순서로 깨뜨릴지 (k는 깬 횟수, idx는 현재 달걀의 idx)
    static void backtrack(int idx) {
        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (egg[i][0] <= 0) cnt++;
            }
            result = Math.max(result, cnt);
            return;
        }
        
        if (egg[idx][0] <= 0) {
            backtrack(idx+1);
            return;
        }
        
        int c = 0;
        for (int j = 0; j < N; j++) {
            if (idx == j) continue;
            if (egg[j][0] > 0) c++;
        }
        if (c == 0) {
            backtrack(idx+1);
            return;
        }
     
        for (int i = 0; i < N; i++) { 
            if (egg[i][0] <= 0) continue; // 안깨진 계란
            if (i == idx) continue; // 자기 자신은 제외 
            int backUpI = egg[i][0];
            int backUpIdx = egg[idx][0];
            egg[i][0] -= egg[idx][1]; // 내구도가 무게만큼 없어짐
            egg[idx][0] -= egg[i][1];
            
            backtrack(idx+1); 
            
            // 복구 
            egg[i][0] = backUpI;
            egg[idx][0] = backUpIdx;
        }
    }
}