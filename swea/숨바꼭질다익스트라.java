package swea;

import java.io.*;
import java.util.*;

public class 숨바꼭질다익스트라 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m;
    static int distance[];
    static List<Integer> graph[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        distance = new int [n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);
        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dijkstra();
        int d = 0;
        int idx = 0;
        for(int i=1; i<=n; i++) {
            if( d < distance[i]) {
                idx = i;//번호
                d = distance[i]; //최단거리
            }
        }
        //count찾기
        int count=0;
        for(int i=1; i<=n; i++) {
            if( d == distance[i]) {
                count++;
            }
        }
        System.out.print(idx + " " + d + " " + count);

}
    private static void dijkstra() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        distance[1] = 0; //시작 위치
        while(!pq.isEmpty()) {
            int x = pq.poll();
            //연결된 위치 업데이트
            for(int next : graph[x]){
                if(distance[next] > distance[x] + 1){
                    distance[next] = distance[x] + 1;
                    pq.offer(next);
                }
            }
        }
    }

}
