import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
public class Boj16236 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static int map[][];
    private static boolean visited[][];
    private static int [][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        Queue<Node> que = new LinkedList<>();

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(input.readLine());
                if(map[i][j] == 9) {
                    que.offer(new Node(i,j,0));
                    map[i][j] = 0;
                }
            }
        }
        int eat = 0; //먹은 물고기
        int time = 0; // 시간
        int age = 2; //상어 길이

        while(true) {
            LinkedList<Node> fish = new LinkedList<>();
            int dist[][] = new int[n][n];
            while(!que.isEmpty()) {
                Node current = que.poll();
                for(int d[] : deltas) {
                    int nx = current.x + d[0];
                    int ny = current.y + d[1];
                    if(nx >=0 && ny>=0 && nx<n && ny<n && dist[nx][ny]==0){
                        if(map[nx][ny] <= age) {
                            dist[nx][ny] = dist[current.x][current.y]+1;
                            que.offer(new Node(nx, ny, dist[nx][ny]));
                            if(1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < age) {
                                fish.add(new Node(nx, ny, dist[nx][ny]));
                            }
                        }
                    }
                }
                if(fish.size() == 0) {
                    System.out.println(time);
                    return;
                }
                Node currentFish = fish.get(0);
                for(int i=1; i<fish.size(); i++) {
                    if(currentFish.dist > fish.get(i).dist) {
                        currentFish = fish.get(i);
                    }
                    else if(currentFish.x == )
                }

            }

        }

    }

    public static class Node {
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
