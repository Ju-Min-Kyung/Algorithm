import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>(
    Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    )
);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer.append(s.charAt(i));
                continue;
            }
            sb.append(s.charAt(i));
            if (map.containsKey(sb.toString())) {
                answer.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
        }
        return Integer.valueOf(answer.toString());
    }
}