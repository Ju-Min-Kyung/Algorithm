class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            if (food[i] > 1) {
                for (int j = 0 ; j < food[i] / 2; j++) {
                    sb.append(i);
                }
            }
        }
        
        StringBuilder reversed = new StringBuilder(sb.toString()).reverse();
        sb.append("0");
        sb.append(reversed);
        String answer = sb.toString();
        return answer;
    }
}