package pra;

import java.io.*;
import java.util.*;
public class 화성탐사 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static int[][] distance, map;
    private static int[][] deltas = {{1,0} , {0,1}, {-1,0} , {0,-1}};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            n = Integer.parseInt(input.readLine());
            map = new int[n][n];
            distance = new int [n][n];
            int INF = Integer.MAX_VALUE;
            for(int i=0; i<n; i++) {
                tokens = new StringTokenizer(input.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                    distance[i][j] = INF;
                }
            }
        }
        dijkstra();

    }
    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int [] {0,0,map[0][0]});
        distance[0][0] = map[0][0];
        while(!pq.isEmpty()){
            int t[] = pq.poll();
            int x = t[0];
            int y = t[1];
            int dis = t[2];
            for(int d[] : deltas){
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<n){
                    if(distance[nx][ny] > dis+map[nx][ny]){
                        distance[nx][ny] = dis+map[nx][ny];
                        pq.offer(new int[] {nx, ny, distance[nx][ny]});
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(distance));

    }
}
