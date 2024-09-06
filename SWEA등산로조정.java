import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA등산로조정 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k, res;
    private static int[][] map;
    private static boolean[][] visited;
    private static int deltas[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int maxHeight;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            maxHeight = Integer.MIN_VALUE;
            res = 0;
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            k = Integer.parseInt(tokens.nextToken());
            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]); // 가장 높은 값 찾기
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, map[i][j], 1, true); // 가장 높은 값에서만 dfs
                        visited[i][j] = false;
                    }
                }
            }
            output.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(output);
    }

    private static void dfs(int x, int y, int h, int length, boolean flag) {
        res = Math.max(length, res); // 계속 갱신
        for (int[] d : deltas) {
            int nx = x + d[0];
            int ny = y + d[1];

            // 범위를 벗어나거나 이미 방문했으면 넘어가기
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

            // k가 없을 때
            if (!flag) {
                // 자신보다 작으면 이동
                if (h > map[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, map[nx][ny], length + 1, flag);
                    visited[nx][ny] = false;
                }
            }
            // k가 있을 때
            else {
                // 자신보다 작으면 이동
                if (h > map[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, map[nx][ny], length + 1, flag);
                    visited[nx][ny] = false;
                }
                // 깎을 수 있는 경우
                else if (h > map[nx][ny] - k) {
                    int origin = map[nx][ny]; // 원래 높이를 저장
                    for (int depth = 1; depth <= k; depth++) { // 1부터 k까지
                        if (h > map[nx][ny] - depth) { // 현재 높이 h가 깎인 후의 높이보다 큰 경우
                            map[nx][ny] -= depth; // 깊이만큼 깎아서 이동
                            visited[nx][ny] = true;
                            dfs(nx, ny, map[nx][ny], length + 1, false); // 깎아서 플래그 사용
                            map[nx][ny] = origin; // 원래 높이로 복구
                            visited[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }
}