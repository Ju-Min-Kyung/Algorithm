import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = 1; // 실제로 넘어간 횟수 
            int currentCount = 0; // skip 제외 카운트 
            char c = s.charAt(i);
            while (index > currentCount) {
                // currentIndex의 문자 
                char newChar = (char) ((c+currentIndex -'a') % 26 + 'a');
                currentIndex++;
                if (!skip.contains(String.valueOf(newChar))) {
                    currentCount++;
                }
            }
            char finalChar = (char) ((c+currentIndex-1 -'a') % 26 + 'a');
            answer.append(finalChar);
        }
        System.out.println(answer.toString());
        return answer.toString();
    }
}