class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        // 소문자 바꾸기 
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, Character.toLowerCase(c));
        }
        // 특수문자 제거
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!(Character.isDigit(c) || Character.isLowerCase(c) || c == '-' || c == '_' || c == '.')) {
                sb.deleteCharAt(i);
                i--;
            }
        }
     
        // 연속된 점
        for (int j = 1; j < sb.length(); j++) {
            if (sb.charAt(j) == '.' && sb.charAt(j-1) == '.') {
                sb.deleteCharAt(j);
                j--;
            }
        }
        // 처음 위차한 점
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
            
        // 아이디가 빈 문자열 
        if (sb.length() == 0) {
            sb.append('a');
        }
            
        // 길이가 16자 이상이면
        if (sb.length() >= 16) {
            for (int k = 15; k < sb.length(); k++) {
                sb.deleteCharAt(k);
                k--;
            }
        }
            
        if (sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
            
        } 
            
        char finalLetter = sb.charAt(sb.length()-1);
        while (sb.length() < 3) {
            sb.append(finalLetter);
            
        }
        String answer = sb.toString();
        return answer;
    }
}