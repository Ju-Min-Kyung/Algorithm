import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static char[][] map;
    static int[] arr;
    static int result;
	public static void main (String[] args) throws Exception
	{
		// 5X5 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		arr = new int[25];
		
		for (int i = 0; i < 5; i++) {
		    String s = br.readLine();
		    for (int j = 0; j < 5; j++) {
		        map[i][j] = s.charAt(j);
		    }
		}
        
        backtrack(0, 0);
        
        System.out.println(result);
	}
	
	static void backtrack(int k, int idx) {
	    if (k == 7) {
	        Deque<Integer> dq = new ArrayDeque<>();
	        int[][] visited = new int[5][5];
	        dq.offerLast(arr[0]);
	        visited[arr[0]/5][arr[0]%5] = 1;
	        int[] dx = {0, 1, -1, 0};
	        int[] dy = {1, 0, 0, -1};
	        int cnt = 1;
	        int sCnt = (map[arr[0]/5][arr[0]%5] == 'S') ? 1 : 0;

	        
	        while (!dq.isEmpty()) {
	            int start = dq.pollFirst();
	            int cx = start / 5;
	            int cy = start % 5;
	            for (int c = 0; c < 4; c++) {
	                int nx = cx + dx[c];
	                int ny = cy + dy[c];
	                
	                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && visited[nx][ny] == 0) {
	                    for (int i = 1; i < 7; i++) {
	                        int x = arr[i] / 5;
	                        int y = arr[i] % 5;
	                        
	                        if (nx == x && ny == y) {
	                            visited[nx][ny] = 1;
	                            cnt++;
	                            if (map[nx][ny] == 'S') {
	                               sCnt++;
	                            }
	                            dq.offerLast(nx * 5 + ny);
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        
	        if (sCnt > 3 && cnt == 7) {
	            result++;
	        }
	        return;
	    }
	    
	    // 조합 
	    if (idx == 25) return;
	    
	    arr[k] = idx;
	    backtrack(k+1, idx+1);
	    backtrack(k, idx+1);
	}
}
