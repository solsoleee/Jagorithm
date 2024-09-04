package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj알파벳 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int r,c,res;
    private static char[][] map;
    private static boolean[][] visited;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        res=1;
        tokens = new StringTokenizer(input.readLine());
        r = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            String line = input.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = line.charAt(j);
            }
        }
        dfs(0,0);
        System.out.println(res);
    }
    private static void dfs(int x, int y){

        if(flag){
            res++;
            return;
        }
        flag = true;
        visited[x][y] = true;

        for(int d[]:deltas){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx>=0 && nx<r && ny>=0 && ny<c){
                if(!visited[nx][ny] && map[x][y]!=map[nx][ny]){
                    visited[nx][ny] = true;
                    flag = false;
                    dfs(nx, ny);

                }
            }
        }
        visited[x][y] = false;
    }
}
