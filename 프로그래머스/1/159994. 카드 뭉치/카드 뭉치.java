class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < goal.length; i++) {
            if (i1 < cards1.length && goal[i].equals(cards1[i1])) {
                i1++;
            }
            else if (i2 < cards2.length && goal[i].equals(cards2[i2])) {
                i2++;
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
}