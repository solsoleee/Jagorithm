package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA치즈도둑 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, res;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            res = 1; // 최소 덩어리 개수는 1
            n = Integer.parseInt(input.readLine());
            map = new int[n][n];

            int min_val = 100, max_val = 1;
            for (int i = 0; i < n; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                    min_val = Math.min(min_val, map[i][j]);
                    max_val = Math.max(max_val, map[i][j]);
                }
            }

            // 각 날에 대해 치즈 덩어리 수 계산
            for (int day = min_val; day <= max_val; day++) {
                visited = new boolean[n][n];
                int total = 0;

                // 오늘 날짜의 치즈를 먹힌 것으로 설정
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == day) {
                            map[i][j] = 0; // 치즈가 먹혀서 없어진 부분을 0으로 설정
                        }
                    }
                }

                // 남아있는 치즈 덩어리 수 계산
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] != 0 && !visited[i][j]) {
                            bfs(i, j);
                            total++;
                        }
                    }
                }

                res = Math.max(res, total);  // 최대 덩어리 수 갱신
            }

            output.append("#").append(t).append(" ").append(res).append('\n');
        }
        System.out.print(output);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] t = que.poll();
            int cx = t[0];
            int cy = t[1];
            for (int[] d : deltas) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != 0) {
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}