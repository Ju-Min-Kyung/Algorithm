import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		int answer = 0;
		
		while((money - 5) % 2 == 0 || (money - 5) > 4) {
		    money -= 5;
		    answer++;
		}
		
		
		while((money - 2) >= 0) {
		    money -= 2;
		    answer++;
		}
		
		
		
		if (money != 0) {
		    System.out.print(-1);
		}
		else {
		    System.out.print(answer);
		}

	}
}
