class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        while (index <= section.length - 1) {
            answer++;
            int start = section[index];
            for (int i = index; i < section.length; i++) {
                if (section[i] - start + 1 <= m) {
                    index = i + 1;
                }
                else {
                    break;
                }
            }
        }
        return answer;
    }
}