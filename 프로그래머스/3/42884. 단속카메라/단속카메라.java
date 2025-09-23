import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int location = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < routes.length; i++) {
            if (location < routes[i][0] || location > routes[i][1]) {
                location = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}