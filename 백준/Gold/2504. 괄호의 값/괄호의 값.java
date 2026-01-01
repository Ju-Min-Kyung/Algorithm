import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque < Character > dq = new ArrayDeque < > ();
        int answer = 0;
        char previous = '\0';
        int weight = 1;
        boolean isCorrect = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                dq.offerLast(c);
                if (c == '(') weight *= 2;
                if (c == '[') weight *= 3;
            }
            else {
                if (!dq.isEmpty()) {
                    // 짝이 맞는지 확인
                    if ((c == ')' && dq.peekLast() != '(') || (c == ']' && dq.peekLast() != '[')) {
                        isCorrect = false;
                        break;
                    }
                    // 이전의 괄호가 여는 괄호일 경우 (중첩 x)
                    if (previous == '(' || previous == '[') {
                        if (c == ')') {
                            answer += weight;
                            weight /= 2;
                        }
                        else if (c == ']') {
                            answer += weight;
                            weight /= 3;
                        }
                    } // 중첩일 경우 
                    else {
                        if (c == ')') {
                            weight /= 2;
                        }
                        else {
                            weight /= 3;
                        }
                    }
                    dq.pollLast();
                }
                else {
                    isCorrect = false;
                }
            }
             previous = c;
        }

        if (isCorrect && dq.isEmpty()) {
            System.out.println(answer);
        }
        else {
            System.out.println("0");
        }
    }
}