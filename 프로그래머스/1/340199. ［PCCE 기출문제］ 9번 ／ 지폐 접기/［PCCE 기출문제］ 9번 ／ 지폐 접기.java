class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billM = Math.max(bill[0], bill[1]);
        int billm = Math.min(bill[0], bill[1]);
        int walletM = Math.max(wallet[0], wallet[1]);
        int walletm = Math.min(wallet[0], wallet[1]);
        
        while (billm > walletm || billM > walletM) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }
            answer += 1;
            billM = Math.max(bill[0], bill[1]);
            billm = Math.min(bill[0], bill[1]);
        }
        return answer;
    }
}