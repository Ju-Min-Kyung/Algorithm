import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) { // 테스트케이스
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long sum = 0;
            // 뒤에서부터 
            for (int i = n-1; i > 0; i--) {
                int spentMoney = 0;
                int stock = 0;
                
                int j = i - 1; // i보다 앞에 있는 
                while (j >= 0 && arr[j] < arr[i]) { // 주식이 오를 때
                    spentMoney += arr[j];
                    stock += 1;
                    j--;
                }
                sum += (stock * arr[i]) - spentMoney;
                i = j + 1; // 상승이 끝났을 경우 
            }
            
            System.out.println(sum);
            
        }
    }
}