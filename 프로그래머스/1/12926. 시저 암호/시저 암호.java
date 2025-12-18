class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                continue;
            }
            if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
                sb.setCharAt(i, (char) ('A' + (sb.charAt(i) - 'A' + n) % 26));
            }
            else if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
                sb.setCharAt(i, (char) ('a' + (sb.charAt(i) - 'a' + n) % 26));
            }
            
        }
        return sb.toString();
    }
}