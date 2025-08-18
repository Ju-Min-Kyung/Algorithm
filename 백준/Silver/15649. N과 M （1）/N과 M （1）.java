import java.util.*;


public class Main {
    static int N, M;
    public static Set<Integer> visited = new HashSet<>();
    public static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        permutation(1);

    }

    public static void permutation(int depth) {
        if (result.size() == M) {

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }
        int value = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                result.add(i);
                permutation(depth+1);
                result.remove(result.size()-1);
                visited.remove(i);
            }
        }
    }
}