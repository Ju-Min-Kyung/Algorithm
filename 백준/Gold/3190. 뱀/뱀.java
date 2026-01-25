import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		Deque<int[]> snake = new ArrayDeque<>();
		
	    int[][] map = new int[N][N];
	    for (int i = 0; i < K; i++) {
	        String s = br.readLine();
	        int y = Integer.parseInt(s.split(" ")[0]);
	        int x = Integer.parseInt(s.split(" ")[1]);
	        
	        map[y-1][x-1] = 2; // 사과 
	    }
	    
	    int L = Integer.parseInt(br.readLine());
	    int[][] dir = new int[L][2];
	    for (int i = 0; i < L; i++) {
	        String s = br.readLine();
	        int second = Integer.parseInt(s.split(" ")[0]);
	        char x = s.split(" ")[1].charAt(0);
	        int direction = x == 'L' ? 1 : 2;
	        dir[i][0] = second;
	        dir[i][1] = direction;
	    }
	    
	    int currentDirection = 0; // 동, 남, 서, 북
	    int time = 0;
	    int currentX = 0;
	    int currentY = 0;
	    int directionIndex = 0;
	    snake.offerFirst(new int[]{0,0});
	    map[0][0] = 1; // 뱀 
	    // 뱀 움직임 구현
	    while(true) {
	        time++;
	        int nextX = 0;
	        int nextY = 0;
	        // 이동 (머리부분) 
	        if (currentDirection == 0) { // 동
 	            nextX = currentX + 1;
 	            nextY = currentY;
	        }
	        else if (currentDirection == 1) { // 남
	            nextY = currentY + 1;
	            nextX = currentX;
	        }
	        else if (currentDirection == 2) { // 서 
	            nextX = currentX - 1;
	            nextY = currentY;
	        }
	        else { // 북
	            nextY = currentY - 1;
	            nextX = currentX;
	        }
	     
	        
	        boolean hasApple = false;
	        if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && map[nextY][nextX] == 2) hasApple = true; 
	        
	        // 머리가 갈 부분 유효성 검사 
	        if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && map[nextY][nextX] != 1) {
	            currentX = nextX;
	            currentY = nextY;
	            snake.offerFirst(new int[]{nextX, nextY});
	        }
	        else {
	            break;
	        }   
	        
	        // 사과 처리 
	        if (!hasApple) { // 사과가 없으면 
	            if (!snake.isEmpty()) {
	                int[] tail = snake.pollLast();
	                map[tail[1]][tail[0]] = 0;
	            }
	        }
	        
	        map[nextY][nextX] = 1;
	        
	        // 방향 처리 
	        if (directionIndex < L && dir[directionIndex][0] == time) { // 시간이 다 됬을 때, 
	           if (dir[directionIndex][1] == 1) { // 왼쪽
	               currentDirection = (currentDirection + 3) % 4;
	           }
	           else { // 오른쪽 
 	               currentDirection = (currentDirection + 1) % 4;
	           }
	           directionIndex++;
	        }
	    }
	    
	    System.out.println(time);

	}
}
