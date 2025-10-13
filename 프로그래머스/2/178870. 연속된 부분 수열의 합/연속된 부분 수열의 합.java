class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        
        int i = 0; // 앞
        int j = 1;
        int sum = sequence[i];
        int min = 100000;
        int a = 0;
        int b = 0;
        
        for (int p = sequence.length-1; p >= k; p--) {
            if (sequence[p] == k) {
                answer[0] = p;
                answer[1] = p;
                return answer;
            }
        }
        
        while (sequence[i] <= k / 2 && j < sequence.length) {
            sum += sequence[j];
            
            if (sum == k) {
    
                if (min > (j - i)) {
                    a = i;
                    b = j;
                    min = j - i;
                 
                    sum = sequence[i];
                }
                i++;
                j = i+1;
            }
            else if (sum > k) {
                i++;
                j = i+1;
                sum = sequence[i];
            }
            else {
                j++;
            }
        }
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}