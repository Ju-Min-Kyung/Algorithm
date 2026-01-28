import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String f = br.readLine();
		int N = Integer.parseInt(f.split(" ")[0]);
		int C = Integer.parseInt(f.split(" ")[1]);
		
		Integer[] input = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    input[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> order = new HashMap<>();
		for (int i = 0; i < N; i++) {
		    map.put(input[i], map.getOrDefault(input[i], 0) + 1);
		    order.putIfAbsent(input[i], i);
		}
		
		Arrays.sort(input, (a, b) -> {
		    if (map.get(a).equals(map.get(b))) return order.get(a) - order.get(b);
		    return map.get(b) - map.get(a);
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
		    sb.append(input[i]).append(" ");
		}
        System.out.println(sb.toString());
	}
}
