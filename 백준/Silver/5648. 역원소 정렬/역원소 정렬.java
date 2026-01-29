import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List < String > list = new ArrayList < > ();
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            if (firstLine) {
                if (st.hasMoreTokens()) st.nextToken();
                firstLine = false;
            }

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
        }

        List < Long > arr = new ArrayList < > ();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            String reversed = sb.toString();
            Long value = Long.parseLong(reversed);
            arr.add(value);
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}