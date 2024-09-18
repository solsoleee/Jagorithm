package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA정사각형방 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int [][] deltas ={{0,1}, {1,0}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            int max_val = Integer.MIN_VALUE;
            n = Integer.parseInt(input.readLine());
            map = new int[n][n];
            int room = Integer.MAX_VALUE;
            for(int i=0; i<n; i++) {
                tokens = new StringTokenizer(input.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    visited = new boolean[n][n];
                    int c = bfs(i,j,1); //완전탐색
                    if(c > max_val) {
                        max_val = c;
                        room = map[i][j];
                    } else if (c==max_val) {
                        if(room > map[i][j]) room = map[i][j];
                    }
                }
            }
            output.append("#").append(t).append(" ").append(room).append(" ").append(max_val).append("\n");
        }
        System.out.print(output);
    }

    static int bfs(int x, int y, int c) {
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int [] {x,y,c});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            c = t[2];
            for(int d[]: deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
                    if(Math.abs(map[dx][dy]-map[nx][ny]) ==1) {
                        que.offer(new int [] {nx,ny,c+1});
                        visited[nx][ny]= true;
                    }
                }
            }
        }
        return c;
    }
}