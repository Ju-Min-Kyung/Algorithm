import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int x = 0; x < k; x++) {
            List <Character> list = new LinkedList<>();
            String N = br.readLine();
            ListIterator<Character> it = list.listIterator(0);

            for (int i = 0; i < N.length(); i++) {
                char c = N.charAt(i);
                switch (c) {
                    case '<':
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        break;
                    case '>':
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '-':
                        if (it.hasPrevious()) {
                            it.previous();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(c);
                        
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char l: list) {
                sb.append(l);
            }
            System.out.println(sb.toString());
        }
    }
}