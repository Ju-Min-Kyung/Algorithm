import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int N, M;
    static int[] arr;
    static int[] isUsed;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // 삼각형의 변의 개수 
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[10];
        isUsed = new int[10];
        
        backTrack(0);
    }

    public static void backTrack(int k) {
        // 수를 다 골랐을 경우
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        
        // 그렇지 않을 경우 
        for(int i = 1; i <= N; i++) {
            if (isUsed[i] != 1) {
                arr[k] = i;
                isUsed[i] = 1;
                backTrack(k+1);
                isUsed[i] = 0; 
            }
        }
    }
}