package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA지뢰찾기 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static char[][] grid;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(input.readLine());
            grid = new char[n][n];
            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String line = input.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            // 지뢰 세기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '.') {
                        map[i][j] = count(i, j);
                    } else {
                        map[i][j] = -1; // 지뢰가 있는 칸
                    }
                }
            }

            // 최소 클릭 수 계산
            int click = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        click++;
                    }
                }
            }

            // 남은 미방문 지뢰 없는 칸 클릭
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        click++;
                    }
                }
            }

            output.append("#").append(t).append(" ").append(click).append("\n");
        }

        System.out.print(output);
    }

    // 주변 8방향 지뢰 개수 세는 함수
    private static int count(int x, int y) {
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == '*') {
                count++;
            }
        }
        return count;
    }

    // BFS
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int cx = t[0];
            int cy = t[1];

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
