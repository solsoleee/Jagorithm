package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA보급로 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;

    static int [][] dist, map;
    static int [][] deltas = {{1,0} , {0,1}, {-1,0} , {0,-1}};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(input.readLine());
            map = new int [n][n];
            dist = new int [n][n];
            for(int i=0; i<n; i++){
                String line = input.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            output.append("#").append(t).append(" ").append(dist[n-1][n-1]).append('\n');
        }
    System.out.print(output);

    }
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,map[0][0]));
        dist[0][0] = map[0][0];
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int x = node.row;
            int y = node.col;
            //현재 들어온게 원래 있던거 보다 작으면 안됨
            if(dist[x][y] < node.weight) continue;
            for(int d[] : deltas){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<n) {
                    //연결된게 현재보다 더 작다면 업데이트
                    int cost = dist[x][y] + map[nx][ny];
                    if(dist[nx][ny] > cost){
                        dist[nx][ny] = cost;
                        pq.offer(new Node(nx,ny,cost));
                    }
                }
            }
        }


    }

    static class Node implements Comparable <Node>{
        int row;
        int col;
        int weight;
        public Node(int row,int col, int weight){
            this.row= row;
            this.col=col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

    }


}
