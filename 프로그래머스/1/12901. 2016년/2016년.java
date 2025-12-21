import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        Map<Integer, Integer> calendar = Map.ofEntries(
            Map.entry(1, 31),
            Map.entry(2, 29),
            Map.entry(3, 31),
            Map.entry(4, 30),
            Map.entry(5, 31),
            Map.entry(6, 30),
            Map.entry(7, 31),
            Map.entry(8, 31),
            Map.entry(9, 30),
            Map.entry(10, 31),
            Map.entry(11, 30),
            Map.entry(12, 31)
        );
        int days = 0;
        for (int i = 1; i < a; i++) {
            days += calendar.get(i);
        }
        days += b;
        switch (days % 7) {
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
            case 0:
                return "THU";
        }
        return answer;
       
    }
}