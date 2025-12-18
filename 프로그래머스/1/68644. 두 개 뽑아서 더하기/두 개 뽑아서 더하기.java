import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {

        Set<Integer> answers = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (i != j) {
                    answers.add(numbers[i] + numbers[j]);
                }
            }
        }
        int[] answer = new int[answers.size()];
        int idx = 0;
        for (int num : answers) {
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}