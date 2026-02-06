import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> numbers = new ArrayList<>(); // 수 
        List<Character> operators = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                operators.add(s.charAt(i));
            }
            
        }
        
        s = s.replaceAll("[+-]", " ");
        
        StringTokenizer st = new StringTokenizer(s);
      
        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        int sum = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            // -가 나왔을 때, 다음 -가 나올 때까지 - 처리 
            if (operators.get(i) == '-') {
                sum -= numbers.get(i+1);
                int index = i+1;
                while (index < operators.size() && operators.get(index) == '+') {
                    sum -= numbers.get(index+1);
                    index++;
                }
                i = index-1;
            }
            else {
                sum += numbers.get(i+1);
            }
        }
        
        System.out.println(sum);
        
    }
}