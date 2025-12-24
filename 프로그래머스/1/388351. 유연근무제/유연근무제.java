class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int saturday = (5 - (startday - 1) + 7) % 7;
        int sunday   = (6 - (startday - 1) + 7) % 7;
        for (int i = 0; i < timelogs.length; i++) {
            int result = 0;
            for (int j = 0; j < timelogs[0].length; j++) {
                int schedule = schedules[i] / 100 * 60 + schedules[i] % 100 + 10;
                if (j != saturday && j != sunday) {
                    int time = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                    System.out.println(schedule + " " + time);
                    if (time <= schedule) {
                        result++;
                    }
                }
            }
            System.out.println(result);
            if (result >= 5) {
                answer++;
            }
        }
        return answer;
    }
}