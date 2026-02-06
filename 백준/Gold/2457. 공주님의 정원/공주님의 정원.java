import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2]; // 늦을수록 앞에
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dates = new int[4];
            for (int j = 0; j < 4; j++) {
                dates[j] = Integer.parseInt(st.nextToken());
            }
            arr[i][0] = dates[0] * 100 + dates[1];
            arr[i][1] = dates[2] * 100 + dates[3];
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0])); // 개화 시작이 빠른 순으로 정렬 
        
        // 3월 1일부터 11월 30일까지 만족하는 꽃 
        int current = 301;
        int index = 0;
        int answer = 0;
        int max = 0; // 가장 늦은 날짜
        
        while (current <= 11 * 100 + 30) {
            max = current;
            while (index < n && arr[index][0] <= current) {
                // 제일 늦게 가는 날짜 찾기 
                if (max < arr[index][1]) {
                    max = arr[index][1];
                    
                }
                index++;
            }
            
            if (current < max) {
                answer++;
                current = max;
            }
            else {
                answer = 0;
                break;
            }
        }
        
        System.out.println(answer);

    }
}