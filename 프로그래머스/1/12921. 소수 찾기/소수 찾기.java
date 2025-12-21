class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int k = 1; k <= n; k++) {
            boolean isDecimal = true;
             if (k == 1) {
                    continue;
            }
            for(int i = 2; i * i <= k; i++) {
                if (k % i == 0) {
                    isDecimal = false;
                    break;
                }
             }
            if (isDecimal) {
                answer++;
            }
        }
        return answer;
    }
}