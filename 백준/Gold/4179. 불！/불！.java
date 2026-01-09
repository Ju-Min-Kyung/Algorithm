import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int R = Integer.parseInt(s.split(" ")[0]); // 행의 개수
		int C = Integer.parseInt(s.split(" ")[1]); // 열의 개수
		char[][] map = new char[R][C];
		
		Deque<int[]> fire = new ArrayDeque<>();
		Deque<int[]> jihun = new ArrayDeque<>();
		
		// 그래프 입력받기 
		for (int r = 0; r < R; r++) {
		   String m = br.readLine();
		   for (int c = 0; c < C; c++) {
		       map[r][c] = m.charAt(c);
		   }
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
	
		// 초기위치 
		for (int i = 0; i < R; i++) {
		    for (int j = 0; j < C; j++) {
		        if (map[i][j] == 'J') {
		            jihun.offerLast(new int[]{i, j});
		        }
		        
		        if (map[i][j] == 'F') {
		            fire.offerLast(new int[]{i, j});
		        }
		    }
		}
		int time = 0;
		while (!jihun.isEmpty()) {
		    time++;
		    int fSize = fire.size();
		    for (int f = 0; f < fSize; f++) {
		        int[] fCurrent = fire.pollFirst();
		        
		        for (int i = 0; i < 4; i++) {
		            int nextX = fCurrent[0] + dx[i];
		            int nextY = fCurrent[1] + dy[i];
		        
		            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && map[nextX][nextY] == '.') {
		                map[nextX][nextY] = 'F';
		                fire.offerLast(new int[]{nextX, nextY});
		            }
		        } 
		    }
		    
		    // 지훈
		    int jSize = jihun.size();
		    for (int j = 0; j < jSize; j++) {
		        int[] jCurrent = jihun.pollFirst();
		        
		        for (int i = 0; i < 4; i++) {
		            int nextX = jCurrent[0] + dx[i];
		            int nextY = jCurrent[1] + dy[i];
		            
		            if (nextX >= R || nextY >= C || nextX < 0 || nextY < 0) {
		                System.out.println(time);
		                return;
		            }
		        
		            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && map[nextX][nextY] == '.') {
		          
		                map[nextX][nextY] = 'J';
		                jihun.offerLast(new int[]{nextX, nextY});
		            }
		        } 
		    }
		}
		
		System.out.println("IMPOSSIBLE");
	}
}
