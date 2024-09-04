import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj미로탐색 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m;
    private static int [][]map;
    private static int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String line = input.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();
        System.out.print(map[n-1][m-1]);
    }
    private static void bfs(){
        Queue <int []> queue = new ArrayDeque<>();
        queue.offer(new int [] {0,0});
        while(!queue.isEmpty()){
            int t[] = queue.poll();
            int x = t[0];
            int y = t[1];
            for(int d[] : deltas){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(map[nx][ny] == 1){
                        map[nx][ny] +=map[x][y];
                        queue.offer(new int [] {nx,ny});
                    }
                }
            }
        }
    }
}
