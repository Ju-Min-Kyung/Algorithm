class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain = n;
        int finalRemain = remain;
        while (remain >= a) {
            System.out.println(remain);
            answer += (remain / a) * b;
            remain -= (finalRemain / a) * a;
            remain += (finalRemain / a) * b;
            finalRemain = remain;
        }
        return answer;
    }
}