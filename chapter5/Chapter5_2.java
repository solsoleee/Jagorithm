package chapter5;

import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Chapter5_2 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m;
    private static int[][] map;
    private static boolean visited[][];
    private static StringTokenizer tokens;
    private static int deltas[][] ={{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            String temp = tokens.nextToken();
            for(int j=0; j<m; j++){
                map[i][j] = temp.charAt(j) -'0';
            }
        }
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }
    private static int bfs(int x, int y){
        Queue <int []> que = new LinkedList<>();
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!que.isEmpty()){
            int t[] = que.poll();
            int a = t[0];
            int b = t[1];
            for(int d[] : deltas){
                int nx = a + d[0];
                int ny = b + d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1){
                    map[nx][ny] = map[a][b] + 1;
                    que.offer(new int[] {nx, ny});
                }
            }
        }

        return 1;
    }

    }
