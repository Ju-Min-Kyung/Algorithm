import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [] arr = new long[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
		    arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		Map<Long, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
		    map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		long answer = arr[0];
		for (Map.Entry<Long, Integer> m: map.entrySet()) {
		    if (max <= m.getValue()) {
		        if (max == m.getValue()) answer = Math.min(m.getKey(), answer);
		        else answer = m.getKey();
		        max = m.getValue();
		    }
		}
		
		System.out.println(answer);
	}
}
