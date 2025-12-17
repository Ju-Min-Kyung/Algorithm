class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a1 = 0;
        
        // 최대공약수 
        for (int i = m; i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                a1 = i;
                break;
            }
        }
        // 최소공약수 
        int a2 = (n / a1) * (m / a1) * a1;
        answer[0] = a1;
        answer[1] = a2;
        return answer;
    }
}