import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 중복 제거 (동일 신고는 1번만 처리)
        Set<String> set = new HashSet<>(Arrays.asList(report));
        String[] reportSet = set.toArray(new String[0]);
        
        // 신고 누적 횟수 map 
        Map<String, Integer> reportMap = new HashMap<>();
        // 신고한 id map (누가 누굴 신고했는가)
        Map<String, List<String>> idMap = new HashMap<>();
        
        // map 만들기 
        for (String r: reportSet) {
            // 신고, 신고자 id 매핑
            StringTokenizer st = new StringTokenizer(r);
            String reportId = st.nextToken();
            String reportedId = st.nextToken();
            idMap.putIfAbsent(reportedId, new ArrayList<>());
            idMap.get(reportedId).add(reportId);
            
            // 누적 횟수 
            reportMap.put(reportedId, reportMap.getOrDefault(reportedId, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry: reportMap.entrySet()) {
            // 신고한 사람 배열 
            List<String> reportIds = new ArrayList<>();
            // 신고횟수가 k 넘으면 
            if (entry.getValue() >= k) {
                // 누가 신고했는가 
                reportIds = idMap.get(entry.getKey());
            }
            // id별로 순회하면서 +1
            for (int i = 0; i < id_list.length; i++) {
                for (int j = 0; j < reportIds.size(); j++) {
                    // 이름이 같으면 
                    if (id_list[i].equals(reportIds.get(j))) {
                        answer[i] += 1;
                    }
                }
            }
        }
        return answer;
    }
}