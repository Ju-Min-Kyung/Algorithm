import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] boxedScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedScore, Collections.reverseOrder());
        for (int i = 0; i <= boxedScore.length - m; i+=m) {
            answer += boxedScore[i+m-1] * m; 
        }
        return answer;
    }
}