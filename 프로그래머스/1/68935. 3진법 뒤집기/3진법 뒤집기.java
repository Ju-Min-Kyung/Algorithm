import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            numbers.add(n%3);
            n /= 3;
        }
        // 배열 뒤집기
        Collections.reverse(numbers);
        for (int i = numbers.size()-1; i >= 0; i--) {
            int value = numbers.get(i);
            double multiply = Math.pow(3, i);
            answer += multiply * value;
        }
        return answer;
    }
}