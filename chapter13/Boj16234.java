package chapter13;

import java.util.*;
import java.io.*;

public class Boj16234 {

    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, l, r;
    private static int[][] map;
    private static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        l = Integer.parseInt(tokens.nextToken());
        r = Integer.parseInt(tokens.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int count = 0;

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) { //방문하지 않았다면
                        List<int[]> list = bfs(i, j);
                        if (list.size() > 1) {
                            int sum = 0;
                            for (int[] pos : list) {
                                sum += map[pos[0]][pos[1]];
                            }
                            int avg = sum / list.size();
                            for (int[] pos : list) {
                                map[pos[0]][pos[1]] = avg;
                            }
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            count++;
        }

        System.out.println(count);
    }

    static List<int[]> bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int[] delta : deltas) {
                int nx = cx + delta[0];
                int ny = cy + delta[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        queue.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return list;
    }
}
