class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        while (index < s.length()) {
            // x
            char x = s.charAt(index);
            int xNumber = 1;
            int otherNumber = 0;
            int index2 = index + 1;
           
            while (index2 < s.length() && xNumber != otherNumber) {
               
                if (s.charAt(index2) != x) {
                    otherNumber++;
                }
                else {
                    xNumber++;
                }
                index2++;
            }
            answer++;
            index = index2;
        }
        return answer;
    }
}