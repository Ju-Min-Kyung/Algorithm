class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String sentence: babbling) {
            sentence = sentence.replaceAll("aya", "1");
            sentence = sentence.replaceAll("ye", "2");
            sentence = sentence.replaceAll("woo", "3");
            sentence = sentence.replaceAll("ma", "4");
            
            boolean isNumber = true;
            for (int i = 0; i < sentence.length(); i++) {
                if (!Character.isDigit(sentence.charAt(i))) {
                    isNumber = false;
                break;
                }
            }
            boolean isAnswer = false;
            if (isNumber) {
                for (int i = 0; i < sentence.length() - 1; i++) {
                    if (sentence.charAt(i) == sentence.charAt(i+1)) {
                        isAnswer = true;
                        break;
                    }
                }
                if (!isAnswer) {
                    System.out.println(sentence);
                    answer++;   
                }
            }
        }
        
        return answer;
    }
}