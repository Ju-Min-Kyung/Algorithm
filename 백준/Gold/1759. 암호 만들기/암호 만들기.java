import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int L, C;
    static char[] arr;
    static int[] isUsed;
    static char[] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        isUsed = new int[C];
        arr = new char[L];
        input = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        backTrack(0, 0);

        sb.append("\n");

        System.out.println(sb.toString());
    }

    static void backTrack(int k, int p) {
        if (k == L) {
            int numOfVowel = 0;
            int numOfConsonant = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    numOfVowel++;
                }
                else {
                    numOfConsonant++;
                }
            }

            if ((numOfVowel >= 1 && numOfConsonant >= 2)) {
                for (int i = 0; i < k; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int x = p; x < C; x++) {
            arr[k] = input[x];
            backTrack(k + 1, x + 1);
        }
    }
}