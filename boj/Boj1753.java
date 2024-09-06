package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1753 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int v,e,k;

    static int dist[];
    static List<Node> graph[];

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        v = Integer.parseInt(tokens.nextToken());
        e = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(input.readLine());
        dist = new int[v+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        graph = new ArrayList[v+1];
        for(int i=0; i<=v; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());
            graph[a].add(new Node(b,c));
        }
        Dijkstra();
        for(int i=1; i<=v; i++){
            if(dist[i]!=INF) System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }
    private static void Dijkstra(){
        PriorityQueue <Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k,0));
        dist[k] = 0; //출발점
        while(!pq.isEmpty()){
            Node node = pq.poll();
            //기존에 있던게 더 작으면 그냥 무시
            if(dist[node.idx] < node.weight) continue;

            //현재 인덱스랑 연결된 노드 업데이트
            for(Node next : graph[node.idx]){
                //현재 연결된거랑 다음거
                int cost = dist[node.idx] + next.weight;
                // 이어있는 게 더 작다면
                if(cost < dist[next.idx]){
                   dist[next.idx] = cost;
                   pq.offer(new Node(next.idx, cost));
                }
            }

        }

    }





    static class Node implements Comparable <Node>{
        int idx;
        int weight;
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

    }

}
