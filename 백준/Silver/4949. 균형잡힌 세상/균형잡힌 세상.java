import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean isCorrect = true;
            Deque < Character > dq = new ArrayDeque < > ();
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    dq.offerLast(c);
                }
                else if (!dq.isEmpty() && (c == ')' || c == ']')) {
                    if ((c == ')' && dq.peekLast() != '(') || (c == ']' && dq.peekLast() != '[')) {
                        isCorrect = false;
                        break;
                    }
                    dq.pollLast();
                }
                else if (dq.isEmpty() && (c == ')' || c == ']')) {
                    isCorrect = false;
                    break;
                }
            }

            if (dq.isEmpty() && isCorrect) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}