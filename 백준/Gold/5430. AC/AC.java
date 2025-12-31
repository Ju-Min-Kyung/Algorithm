import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();

            // 배열 파싱
            if (n > 0) {
                String sub = s.substring(1, s.length() - 1);
                StringTokenizer st = new StringTokenizer(sub, ",");
                while (st.hasMoreTokens()) {
                    dq.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            boolean reversed = false;
            boolean error = false;

            // 명령 처리
            for (int i = 0; i < command.length(); i++) {
                char c = command.charAt(i);

                if (c == 'R') {
                    reversed = !reversed;
                } else { // 'D'
                    if (dq.isEmpty()) {
                        output.append("error\n");
                        error = true;
                        break;
                    }
                    if (!reversed) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (error) continue;

            // 출력
            output.append("[");
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                if (!reversed) {
                    output.append(dq.pollFirst());
                } else {
                    output.append(dq.pollLast());
                }
                if (i < size - 1) output.append(",");
            }
            output.append("]\n");
        }

        System.out.print(output.toString());
    }
}
