package chapter5;

import java.io.*;
import java.util.*;

public class Chapter5_1 {

    private static int n, m;
    private static int map[][];
    private static boolean visited[][];
    private static int  deltas[][] = {{1,0},{-1,0},{0,1}, {0,-1}};


    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub


        //Scanner sc = new Scanner(System.in);
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int [n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {

            tokens = new StringTokenizer(input.readLine());
            String temp = tokens.nextToken();
            for(int j=0; j<m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        int count=0;
        //bfs의 횟수를 세면 됨
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==0) {
                    if(!visited[i][j]) {
                        //System.out.println(i + " " + j);
                        bfs(i,j);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }
    private static void bfs(int x, int y) {
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {x,y});
        visited[x][y]=true;
        while(!que.isEmpty()) {
            int t[]=que.poll();
            int a = t[0];
            int b = t[1];
            for(int i=0; i<4; i++) {
                int nx = a + deltas[i][0];
                int ny = b + deltas[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==0) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        que.offer(new int[] {nx,ny});
                    }
                }
            }
        }

    }
}