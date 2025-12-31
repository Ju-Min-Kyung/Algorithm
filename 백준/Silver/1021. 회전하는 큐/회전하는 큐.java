import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);

        Deque < Integer > dq = new ArrayDeque < > ();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[st.countTokens()];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            int current = 0;
            while (dq.peekFirst() != input[i]) {
                int first = dq.peekFirst();
                int last = dq.peekLast();

                int idx = 0;
                for (int x: dq) {
                    if (x == input[i]) break;
                    idx++;
                }
                
                // 앞에서 접근해야 할 경우
                if (Math.min(idx, dq.size()-idx) == idx) {
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
                else {
                    // 뒤에서 접근해야 할 경우 
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
            }

            dq.pollFirst();
        }
        System.out.println(answer);
    }
}