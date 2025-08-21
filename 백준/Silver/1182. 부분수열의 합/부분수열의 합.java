import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

class Main {
    static int check = 0;
    static int S = 0;
    static int N = 0;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        S = Integer.parseInt(line.split(" ")[1]);

        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> sequence = new ArrayList<Integer>();
        backtrack(sequence, 0, 0);

        System.out.println(check);
    }

    public static void backtrack(List<Integer> seq, int start, int depth) {
        int sum = seq.stream().mapToInt(Integer::intValue).sum();
        if (seq.size() > 0) {
            if (sum == S) {
                check++;
            }
        }
        
        if (N == seq.size()) {
            return;
        }

        for (int i = start; i < N; i++) {
            seq.add(array[i]);
            backtrack(seq, i+1, depth+1);
            seq.remove(seq.size()-1);
        }

    }

}