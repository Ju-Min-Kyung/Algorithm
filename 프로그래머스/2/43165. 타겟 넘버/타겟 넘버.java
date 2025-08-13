class Solution {
    public static int sumValue = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(0, 0, target, numbers);
        answer = sumValue;
        return answer;
    }
    
    public void dfs(int sum, int index, int target, int[] numbers) {
        if (index == numbers.length) {
            if (sum == target) {
                sumValue++;
            }
            return;
        }
            
        dfs(sum + numbers[index], index + 1, target, numbers);
        dfs(sum - numbers[index], index + 1, target, numbers);
    }
}