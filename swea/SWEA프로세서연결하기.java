package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class SWEA프로세서연결하기 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int N, maxConnected, minWire;
    private static int[][] grid;
    private static List<int[]> core;
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 방향
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(input.readLine());
            grid = new int[N][N];
            core = new ArrayList<>();
            maxConnected = 0;
            minWire = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(tokens.nextToken());
                    if (grid[i][j] == 1) { // 코어가 있는 경우
                        if (!(i == 0 || j == 0 || i == N - 1 || j == N - 1)) {
                            core.add(new int[]{i, j}); // 가장자리가 아닌 경우에만 추가
                        }
                    }
                }
            }

            dfs(0, 0, 0);
            output.append("#").append(t).append(" ").append(minWire).append("\n");
        }
        System.out.print(output.toString());
    }

    // 백트래킹
    static void dfs(int cnt, int connected, int wire) {
        if (cnt == core.size()) {
            if (maxConnected < connected) {
                maxConnected = connected;
                minWire = wire;
            } else if (maxConnected == connected) {
                minWire = Math.min(minWire, wire);
            }
            return;
        }

        int[] c = core.get(cnt);
        int x = c[0];
        int y = c[1];

        // 코어 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int len = 0;
            boolean flag = true;

            // 그 방향에 계속해서 놓을 수 있는지 확인
            while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (grid[nx][ny] != 0) { // 다른 코어나 전선이 있는 경우
                    flag = false;
                    break;
                }
                nx += dx[i];
                ny += dy[i];
            }

            // 그 방향에 전선을 놓을 수 있는 경우
            if (flag) {
                nx = x + dx[i];
                ny = y + dy[i];
                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    grid[nx][ny] = 2; // 전선 설치
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                }

                // 다음 코어로 이동
                dfs(cnt + 1, connected + 1, wire + len);

                // 백트래킹, 코어 제거하고 전선 제거 (방향 반대로)
                nx = x + dx[i];
                ny = y + dy[i];
                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    grid[nx][ny] = 0; // 전선 제거
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        // 현재 코어를 연결하지 않고 다음 코어로 이동
        dfs(cnt + 1, connected, wire);
    }
}
