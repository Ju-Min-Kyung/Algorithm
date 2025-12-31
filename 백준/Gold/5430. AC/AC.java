import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 개수
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 명령어
            String command = br.readLine();
            // 배열 개수
            int n = Integer.parseInt(br.readLine());
            // 명령어 입력 
            String s = br.readLine();
            Deque < Integer > dq = new ArrayDeque < > ();

            if (n > 0) {
                String sub = s.substring(1, s.length() - 1);
                String[] array = sub.split(",");
                for (int i = 0; i < array.length; i++) {
                    dq.addLast(Integer.parseInt(array[i]));
                }
            }


            int direction = 0; // 0이 앞, 1이 뒤
            boolean error = false;
            for (int k = 0; k < command.length(); k++) {
                if (command.charAt(k) == 'R') {
                    int center = dq.size() / 2;
                    int temp[] = new int[center];
                    // 방향 바꾸기
                    direction = direction == 1 ? 0 : 1;
                }
                else {
                    if (dq.size() > 0) {
                        if (direction == 0) {
                            dq.pollFirst();
                        }
                        else {
                            dq.pollLast();
                        }
                    }
                    else {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                }
            }

            if (error) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int size = dq.size();
            sb.append("[");

            for (int i = 0; i < size; i++) {
                if (direction == 0) {
                    sb.append(dq.pollFirst());
                }
                else {
                    sb.append(dq.pollLast());
                }

                if (i < size - 1) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

    }
}