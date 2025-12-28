class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healthLimit = health;
        int answer = 0;
        // 마지막 공격 초 구하기 
        int lastAttack = attacks[attacks.length-1][0];
        // 연속 붕대감기 count 
        int successCount = 0;
        // 마지막 공격 시간까지 돌면서 구하기 
        for (int i = 1; i <= lastAttack; i++) {
            if (health <= 0) {
                break;
            }
            boolean isAttacked = false;
            // 몬스터 공격 
            for (int j = 0; j < attacks.length; j++) {
                if (attacks[j][0] == i) {
                    health -= attacks[j][1];
                    isAttacked = true;
                    successCount = 0;
                    break;
                }
            }
            // 공격 안 받을 시 
            if (!isAttacked) {
                successCount++;
                // 초 당 회복
                health += bandage[1];
                health = Math.min(healthLimit, health);
            }
            // 연속 붕대감기 성공 시 
            if (successCount == bandage[0]) {
                successCount = 0;
                health += bandage[2];
                health = Math.min(healthLimit, health);
            }
        }
        answer = health;
        if (health <= 0) {
            return -1;
        }
        return answer;
    }
}