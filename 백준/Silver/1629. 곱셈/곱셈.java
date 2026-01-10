import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
    
        long number = multiply(A, B, C);
        System.out.println(number);
	}
	
	public static long multiply(Long a, Long b, Long c) {
	    if (b == 1) {
	        return a % c;
	    }
	    
	    long half = multiply(a, b / 2, c);
	    long result = (half * half) % c;
	    if (b % 2 == 1) {
            result = (result * a) % c;
        }
	    return result;
	}
}
