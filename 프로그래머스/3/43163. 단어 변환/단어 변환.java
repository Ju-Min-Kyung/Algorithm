import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Deque<String> dq = new ArrayDeque<>();
        dq.offerLast(begin);
        Map<String, Integer> map = new HashMap<>();
        
        while (!dq.isEmpty()) {
            String word = dq.pollFirst();
            
            if (word.equals(target)) {
                return map.get(word);
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) { 
                    int diffCount = 0;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (word.charAt(j) != words[i].charAt(j)) {
                            diffCount += 1;
                        }
                        
                    }
                    
                    if (diffCount == 1) {
                        dq.offerLast(words[i]);
                        map.put(words[i], map.getOrDefault(word, 0) + 1);   
                    }
                }
            }
        }
        return answer;
    }
}