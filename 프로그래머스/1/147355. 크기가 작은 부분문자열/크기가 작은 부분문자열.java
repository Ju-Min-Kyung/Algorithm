class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        for (int i = 0; i <= t.length()-length; i++) {
            String slice = t.substring(i, i+length);
            if (slice.compareTo(p) <= 0) {
                answer++;
            }
        }
            
        return answer;
    }
}