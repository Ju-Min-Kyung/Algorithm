import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inputs = new String[N];
		
		for (int i = 0; i < N; i++) {
		    inputs[i] = br.readLine();
		}
		
		Arrays.sort(inputs, (a, b) -> {
		    
		    // 길이가 짧은게 앞으로 
		    if (a.length() != b.length()) return a.length() - b.length();
		    
		    // 자리수의 합
		    int sumA = 0; 
		    int sumB = 0;
		    for (char c: a.toCharArray()) {
		        if (c >= '0' && c <= '9') sumA += (c - '0');
		    }
		    for (char c: b.toCharArray()) {
		        if (c >= '0' && c <= '9') sumB += (c - '0');
		    }
		    
		    if (sumA != sumB) return sumA - sumB;
		    
		    return a.compareTo(b);
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s: inputs) {
		    sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
	}
}
