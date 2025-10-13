class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        
        int i = 0;
        int j = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        
        while (j < sequence.length) {
            if (sum == k) {
                if (min > j - i) {
                    min = j - i;
                    a = i;
                    b = j;
                }
                sum -= sequence[i];
                i++;
            }
            else if (sum > k) {
                sum -= sequence[i];
                i++;
            }
            else {
                j++;
                if (j < sequence.length) {
                    sum += sequence[j];
                }
            }
        }
        
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}
