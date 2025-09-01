import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. List로 변환
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        // 2. lost와 reserve 겹치는 학생 제거
        List<Integer> overlap = new ArrayList<>(lostList);
        overlap.retainAll(reserveList);
        lostList.removeAll(overlap);
        reserveList.removeAll(overlap);

        // 3. 체육복 대여
        Collections.sort(reserveList); // 작은 번호부터 처리
        for (int r : reserveList) {
            if (lostList.contains(r - 1)) lostList.remove((Integer)(r - 1));
            else if (lostList.contains(r + 1)) lostList.remove((Integer)(r + 1));
        }

        // 4. 최종 답 계산
        return n - lostList.size();
    }
}
