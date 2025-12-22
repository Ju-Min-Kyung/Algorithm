import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> score = new HashMap<>();
        
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] <= 3) {
                // 성격유형 타입
                char type = survey[i].charAt(0);
                score.put(type, score.getOrDefault(type, 0) + 4 - choices[i]);
            }
            else if (choices[i] >= 5) {
                // 성격유형 타입
                char type = survey[i].charAt(1);
                score.put(type, score.getOrDefault(type, 0) + choices[i] - 4);
            }
        }
        // 성격유형 결과
        char type1 =
            score.getOrDefault('R', 0) >= score.getOrDefault('T', 0) ? 'R' : 'T';

        char type2 =
            score.getOrDefault('C', 0) >= score.getOrDefault('F', 0) ? 'C' : 'F';

        char type3 =
            score.getOrDefault('J', 0) >= score.getOrDefault('M', 0) ? 'J' : 'M';

        char type4 =
            score.getOrDefault('A', 0) >= score.getOrDefault('N', 0) ? 'A' : 'N';
        
        sb.append(type1);
        sb.append(type2);
        sb.append(type3);
        sb.append(type4);
        
        String answer = sb.toString();
        return answer;
    }
}