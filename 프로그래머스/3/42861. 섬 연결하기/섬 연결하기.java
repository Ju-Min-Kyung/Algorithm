import java.util.*;

class Edge {
    int node;
    int weight;
    
    public Edge(int node, int weight){  
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        Set<Integer> visited = new HashSet<>();
        int connectedArea = 1;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < costs.length ; i++) {
            int node = costs[i][0];
            int link = costs[i][1];
            int weight = costs[i][2];
            
            graph.get(node).add(new Edge(link, weight));
            graph.get(link).add(new Edge(node, weight));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        // 시작 노드는 0
        int node = 0;
        for (int i = 0; i < graph.get(0).size(); i++) {
            pq.add(graph.get(0).get(i));
            System.out.print(graph.get(0).get(i).node + " ");
        }
        visited.add(0);
    
        while (connectedArea < n) {
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (!visited.contains(edge.node)) {
                    node = edge.node;
                    answer += edge.weight;
                    connectedArea++;
                    visited.add(edge.node);
                    for (int i = 0; i < graph.get(node).size(); i++) {
                        pq.add(graph.get(node).get(i));
                    }
                    break;
                }
            }
        }
    
        return answer;
    }
}
