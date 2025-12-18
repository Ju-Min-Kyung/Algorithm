import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> dict = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {
                int value = dict.get(s.charAt(i));
                answer[i] = i - value;
                dict.put(s.charAt(i), i);
            }
            else {
                answer[i] = -1;
                dict.put(s.charAt(i), i);
            }
        }
        return answer;
    }
}