import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int W = Integer.parseInt(s.split(" ")[1]);
        int L = Integer.parseInt(s.split(" ")[2]);

        Deque < Integer > dq = new ArrayDeque < > ();
        List < int[] > bridge = new ArrayList < > (); // 다리에있는 트럭 
        int arrived = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int truckWeight = Integer.parseInt(st.nextToken());
            dq.offerLast(truckWeight);
        }

        // 단위 시간 
        int time = 0;
        // 현재 다리에 올라가있는 트럭 무게의 합
        int weightSum = 0;
        // 다리에 올라간 트럭 인덱스 
        int index = 0;

        // 시뮬레이션 
        while (arrived < n) {
            // 다리에 있는 트럭들 거리 갱신 
            for (int i = arrived; i < bridge.size(); i++) {
                bridge.get(i)[1] += 1;
            }
            
            // 맨 앞 트럭이 도착하면 
            if (bridge.size() > 0 && bridge.get(arrived)[1] >= W) {
                weightSum -= bridge.get(arrived)[0];
                arrived += 1;
            }

            // 다리에 올리기 
            if (dq.size() > 0 && dq.peekFirst() + weightSum <= L) {
                int truck = dq.pollFirst();
                bridge.add(new int[] {
                    truck, 0
                });
                weightSum += truck;
            }

            time += 1;
        }

        System.out.println(time);

    }
}