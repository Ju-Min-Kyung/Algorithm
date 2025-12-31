import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new LinkedList < > ();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        ListIterator<Integer> it = list.listIterator(0);
        StringBuilder sb = new StringBuilder("<");
        
        while (list.size() > 0) {
            // k번만큼 it 움직임
            for (int i = 0; i < K-1; i++) {
                if (!it.hasNext()) {
                    it = list.listIterator(0);
                }
                it.next();
            }
            
            if (!it.hasNext()) it = list.listIterator(0);
            int v = it.next();
            sb.append(String.valueOf(v));
            it.remove();
            
            if (!list.isEmpty()) sb.append(", "); 
        }
        sb.append(">");
        
        System.out.println(sb.toString());
    }
    
}