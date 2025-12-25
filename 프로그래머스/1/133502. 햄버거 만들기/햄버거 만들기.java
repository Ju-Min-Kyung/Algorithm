import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> hamburger = new ArrayList<>();
        for (int in: ingredient) {
            hamburger.add(in);
            if (hamburger.size() > 3) {
                if (hamburger.get(hamburger.size()-4) == 1 && hamburger.get(hamburger.size()-3) == 2 && hamburger.get(hamburger.size()-2) == 3 && hamburger.get(hamburger.size()-1) == 1) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        hamburger.remove(hamburger.size() - 1);
                    }
                }
            }
        }
        return answer;
    }
}