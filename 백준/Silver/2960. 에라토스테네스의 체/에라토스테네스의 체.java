import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] array = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            array[i] = i;
        }
        int pointer = 2;
        int check = 0;
        while (check < K) {
            for (int p = pointer; p <= N; p++) {
                if (p % pointer == 0 && array[p] != 0) {
                    array[p] = 0;
                    check++;
                    if (check == K) {
                        System.out.println(p);
                        return;
                    }
                }
            }

            for (int k = pointer + 1; k <= N; k++) {
                if (array[k] != 0) {
                    pointer = k;
                    break;
                }
            }

        }
    }
}