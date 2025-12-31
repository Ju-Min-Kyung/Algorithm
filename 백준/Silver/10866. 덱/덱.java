import java.util.*;
import java.io.*;

class Main {

    static class MyDeque {
        int MX = 100000;
        int[] arr = new int[MX * 2 + 1];
        int head = MX;
        int tail = MX;

        public int size() {
            return tail - head;
        }

        public void pushBack(int num) {
            arr[tail++] = num;
        }

        public void pushFront(int num) {
            arr[--head] = num;
        }

        public void popFront() {
            if (size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(arr[head++]);
            }
        }

        public void popBack() {
            if (size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(arr[--tail]);
            }
        }

        public void empty() {
            System.out.println(size() == 0 ? "1" : "0");
        }

        public void front() {
            if (size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(arr[head]);
            }
        }

        public void back() {
            if (size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(arr[tail - 1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MyDeque dq = new MyDeque();

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.countTokens() > 1) {
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("push_front")) {
                    dq.pushFront(num);
                } else if (command.equals("push_back")) {
                    dq.pushBack(num);
                }
            } else {
                String command = st.nextToken();

                if (command.equals("size")) {
                    System.out.println(dq.size());
                } else if (command.equals("front")) {
                    dq.front();
                } else if (command.equals("back")) {
                    dq.back();
                } else if (command.equals("empty")) {
                    dq.empty();
                } else if (command.equals("pop_front")) {
                    dq.popFront();
                } else if (command.equals("pop_back")) {
                    dq.popBack();
                }
            }
        }
    }
}
