package s;

import java.io.*;
import java.util.*;

public class Boj14502 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer output = new StringBuffer();
    private static StringTokenizer tokens;
    private static int n,m;
    private static int[][] map, temp;
    private static boolean[][] visited;
    private static int [][] deltas = {{0,1}, {1,0}, {-1,0},{0,-1}};
    private static int max_value = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        temp = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
//        virus(map, 0, 0);
//        int res = sum(map);
//        System.out.println(res);
        //temp에 map을 복사할것 왜냐면 계속 바뀌니까

        set(map,0);
        System.out.println(max_value);
//        virus();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }
    private static void set(int map[][], int depth){
        if(depth==3){
            virus();
            int total = sum(temp);
            max_value = Math.max(total, max_value);
            return;
        }
        //벽을 3개 세우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    map[i][j]=1;
                }
                set(map, depth+1);
                map[i][j]=0;
            }
        }
    }
    //바이러스 퍼뜨림
    private static void virus(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j]=false;
            }
        }

        //map을 copy해서 쓰기
        for(int i=0; i<n; i++){
            temp[i] = map[i].clone();
        }

        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(temp[i][j]==2){
                    x = i;
                    y = j;
                }
            }
        }

        Queue <int[]> que = new LinkedList<>();
        que.offer(new int[] {x,y});
        visited[x][y] = true;
        while(!que.isEmpty()){
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[] : deltas){
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<m && temp[nx][ny]==0){
                    if(!visited[nx][ny]){
                        temp[nx][ny]=2;
                        que.offer(new int [] {nx, ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }

    }
    //개수 세기
    private static int sum(int [][] temp){
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(temp[i][j]==0) {
                    count++;
                }
            }
        }
        return count;
    }
}
