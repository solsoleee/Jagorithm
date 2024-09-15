package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj도시분할계획 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m;
    static int parents[];

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        parents = new int [n+1];
        for(int i=1; i<=n; i++) {
            parents[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());
            pq.offer(new Edge(a,b,c));
        }
        int sum =0 ;
        int len =0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if( union(e.start, e.end) ){
                System.out.println(e.start +" "+e.end +" " + e.w);
                sum += e.w;
                len = e.w;
            }
        }
        System.out.println(sum-len);
    }

    static int findSet(int x) {
        if(parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }
    static boolean union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA == rootB) return false; //같은 집합
        if(rootA < rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int w;
        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

}
