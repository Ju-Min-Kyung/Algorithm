import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, M;
    static int cnt;
    static int[] isUsed1; // 열
    static int[] isUsed2; // 대각선1
    static int[] isUsed3; // 대각선2
    
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // 퀸의 개수 
        N = sc.nextInt();
        isUsed1 = new int[2*N];
        isUsed2 = new int[2*N];
        isUsed3 = new int[2*N];
        cnt = 0;
        backTrack(0);
        System.out.println(cnt);
    }

    public static void backTrack(int cur) {
        // 수를 다 골랐을 경우
        if (cur == N) {
            cnt++;
            return;
        }
        
        // 그렇지 않을 경우 
        for(int i = 0; i < N; i++) {
            // 조건 체크
            if (isUsed1[i] == 1 || isUsed2[i+cur] == 1 || isUsed3[cur-i+N-1] == 1) {
                continue;
            }
            
            isUsed1[i] = 1;
            isUsed2[cur+i] = 1;
            isUsed3[cur-i+N-1] = 1;
            backTrack(cur+1);
            isUsed1[i] = 0;
            isUsed2[cur+i] = 0;
            isUsed3[cur-i+N-1] = 0;
        }
    }
}