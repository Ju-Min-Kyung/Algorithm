class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int decimals = countDivisors(i);
            if (decimals <= limit) {
                answer += decimals;
            }
            else {
                answer += power;
            }
        }
        return answer;
    }
    
    private int countDivisors(int n) {
        int cnt = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;              
                if (i != n / i) {
                    cnt++;          
                }
            }
        }
        return cnt;
    }
}