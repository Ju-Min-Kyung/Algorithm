import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        for (char c: X.toCharArray()) {
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }
        for (char c: Y.toCharArray()) {
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: xMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            // ymap에 있는지 
            int yNumber = yMap.getOrDefault(key, 0);
            // 짝 
            int pair = value >= yNumber ? yNumber : value;
            // stringbuilder 에 넣기 
            for (int i = 0; i < pair; i++) {
                sb.append(key);
            }
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        sb.setLength(0);
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.setLength(0);
            sb.append('0');
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        String answer = sb.toString();
        return answer;
    }
}