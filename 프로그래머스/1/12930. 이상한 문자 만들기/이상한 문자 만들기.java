import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true); 
        
        int n = st.countTokens();
        
        for (int j = 0; j < n; j++) {
            String token = st.nextToken();
            if (token.equals(" ")) {
                answer.append(" ");
                continue;
            }
            
            StringBuilder sb = new StringBuilder(token);

            for (int i = 0; i < sb.length(); i++) {
                if (i % 2 == 0) {
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                }
                else {
                    sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                }
            }

            answer.append(sb);
        }
        
        return answer.toString();
    }
}