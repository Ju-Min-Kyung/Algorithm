import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int scoreIndex = 0;
        int[] scores = new int[3];
        Map<Character, Integer> map = Map.of(
            'S', 1,
            'D', 2,
            'T', 3
        );
        // 점수 처리 
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                int score = 0;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++; 
                } else {
                    score = c - '0';
                }
                int option = map.get(dartResult.charAt(i+1));
                int result = (int) Math.pow(score, option);
                scores[scoreIndex++] = result; 
                i++;
            }
            else if (c == '*') {
                scores[scoreIndex - 1] *= 2;
                if (scoreIndex - 2 >= 0) {
                    scores[scoreIndex - 2] *= 2;
                }
             }
            else if (c == '#') {
                scores[scoreIndex - 1] *= -1;
            }
        }
        for (int score: scores) {
            answer += score;
        }
        return answer;
    }
}