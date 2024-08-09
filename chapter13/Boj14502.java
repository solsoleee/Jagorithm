package chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer output = new StringBuffer();
    private static StringTokenizer tokens;
    private static int n,m;
    private static int[][] map;
    private static int temp[][];
    private static boolean[][] visited;
    private static int [][] deltas = {{0,1}, {1,0}, {-1,0},{0,-1}};
    private static int max_value = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        dfs(0);
        System.out.println(max_value);
    }

    private static void dfs(int count) { //벽을 3개 세움
        if (count == 3) {
            virus();
            int total = sum(temp); //현재의 개수
            max_value = Math.max(total, max_value);
            //1. 바이러스 퍼뜨림
            //2. 그 당시 temp의 개수셈
            //3. 큰 것을 고름
            return;
        }
        //3개가 차지 않았을 때 벽을 3개 세우는거
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; //벽을 세우는거
                    dfs(count+1); //3개 될때까지 호출
                    map[i][j]=0; //다시 백
                }
            }
        }
    }
        private static void virus () {
            //복사함
            temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                temp[i] = map[i].clone();
            }
            visited = new boolean[n][m]; //초기화
            //맨 처음의 바이러스를 찾아서 퍼짐
            Queue<int[]> que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        que.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            while (!que.isEmpty()) {
                int t[] = que.poll();
                int dx = t[0];
                int dy = t[1];
                for (int d[] : deltas) {
                    int nx = dx + d[0];
                    int ny = dy + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] == 0) {
                        if (!visited[nx][ny]) {
                            temp[nx][ny] = 2;
                            que.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        //개수 세는거
        private static int sum ( int[][] temp){
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }