import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            counter.put(players[i], i);
        }
        
        for (String c: callings) {
            // 이름이 불린 선수 index
            int index = counter.get(c);
            // 앞지를 선수 
            String player = players[index-1];
            players[index-1] = c;
            players[index] = player;
            counter.put(c, index-1);
            counter.put(player, index);
        }
        answer = players;
        return answer;
    }
}