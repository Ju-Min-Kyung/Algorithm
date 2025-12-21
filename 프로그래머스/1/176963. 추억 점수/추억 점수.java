import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String p: photo[i]) {
                if (scoreMap.containsKey(p)) {
                    score += scoreMap.get(p);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}