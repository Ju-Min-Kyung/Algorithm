import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        String[] finals = new String[set.size()];
        int idx = 0;
        for (String s: set) {
            finals[idx] = s;
            idx++;
        }
        
        
        Arrays.sort(finals, (a, b) -> {
            if (a.length() != b.length()) return a.length()-b.length();
            return a.compareTo(b);
        });
        
        for (String s: finals) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}