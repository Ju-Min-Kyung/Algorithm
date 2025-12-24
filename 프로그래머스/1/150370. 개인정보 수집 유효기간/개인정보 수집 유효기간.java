import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        // terms를 담을 map 
        Map<String, Integer> map = new HashMap<>();
        for (String s: terms) {
            StringTokenizer st = new StringTokenizer(s);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        // 오늘날짜
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8, 10));
        int index = 1;
        
        for (String privacy: privacies) {
            StringTokenizer st = new StringTokenizer(privacy);
            String date = st.nextToken();
            String grade = st.nextToken();
            // 보관할 기간
            int privacyMonth = map.get(grade);
            int year = Integer.parseInt(privacy.substring(0, 4));
            int month = Integer.parseInt(privacy.substring(5, 7));
            int day = Integer.parseInt(privacy.substring(8, 10));
            System.out.println(privacyMonth);
            
            // 보관 유효기간
            if (month + privacyMonth > 12) {
                year += (privacyMonth / 12);
                month += (privacyMonth % 12);
                if (month > 12) {
                    year += 1;
                    month -= 12;
                    
                }
            }
            else {
                month += privacyMonth;
            }
            if (day == 1) {
                month -= 1;
                day = 28;
            }
            else {
                day -= 1;
            }
            
            System.out.println(year + " " + month + " " + day);
            
            // 오늘과 비교 
            if (year < todayYear) {
                list.add(index);
            }
            else if (year == todayYear && month < todayMonth) {
                list.add(index);
            }
            else if (year == todayYear && month == todayMonth && day < todayDay) {
                list.add(index);
            }
            index++;
        }
      
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}