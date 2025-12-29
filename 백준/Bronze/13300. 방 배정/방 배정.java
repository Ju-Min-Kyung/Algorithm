import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
	    int answer = 0;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    // 학생 수 
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    // 한 방에 묵을 수 있는 최대 인원
	    int K = Integer.parseInt(st.nextToken());
	    int[][] students = new int[6][2];
	    
	    for (int i = 0; i < N; i++) {
	        StringTokenizer s = new StringTokenizer(br.readLine());
	        int gender = Integer.parseInt(s.nextToken());
	        int grade = Integer.parseInt(s.nextToken());
	        students[grade-1][gender]++;
	    }
	    
	    for (int i = 0; i < students.length; i++) {
	        for (int j = 0; j < students[0].length; j++) {
	            int rooms = (int) Math.ceil((students[i][j]) / (double) K);
	            answer += rooms;
	        }
	    }
	    
	    System.out.println(answer);
	}
}
