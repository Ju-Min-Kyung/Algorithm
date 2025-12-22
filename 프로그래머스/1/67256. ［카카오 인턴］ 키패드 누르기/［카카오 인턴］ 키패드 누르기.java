class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 키패드 위치
        int[][] location = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2}, 
            {2, 0},
            {2, 1}, 
            {2, 2},
        };
        int[] currentL = {3, 0};
        int[] currentR = {3, 2};
        for(int n: numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append('L');
                currentL = location[n];
            }
            else if (n == 3 || n == 6 || n == 9) {
                sb.append('R');
                currentR = location[n];
            }
            else {
                int[] l = location[n];
                int distanceL = Math.abs(currentL[0] - l[0]) + Math.abs(currentL[1] - l[1]);
                int distanceR = Math.abs(currentR[0] - l[0]) + Math.abs(currentR[1] - l[1]);
                
                if (distanceL == distanceR) {
                    if (hand.equals("right")) {
                        sb.append('R');
                        currentR = l;
                    }
                    else {
                        sb.append('L');
                        currentL = l;
                    }
                    
                }
                else {
                    if (distanceL < distanceR) {
                        sb.append('L');
                        currentL = l;
                    }
                    else {
                        sb.append('R');
                        currentR = l;
                    }
                }

            }
        }
        String answer = sb.toString();
        return answer;
    }
}