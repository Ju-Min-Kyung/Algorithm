import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i]-1] == 0) {
                    continue;
                }
                else {
                    if (list.size() > 0) {
                        int previousDoll = list.get(list.size()-1);
                        if (previousDoll == board[j][moves[i]-1]) {
                            answer += 2;
                            list.remove(list.size()-1);
                        }
                        else {
                            list.add(board[j][moves[i]-1]); 
                        }
                    }
                    else {
                        list.add(board[j][moves[i]-1]);
                    }
                   
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}