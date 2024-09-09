package pra;

import java.io.*;
import java.util.*;

public class 최단거리 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static long distance[][];
    static int n,m;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(input.readLine());
            m = Integer.parseInt(input.readLine());
            distance = new long[n + 1][n + 1];
            int INF = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j) distance[i][j] = INF;
                }
            }
            for (int i = 0; i < m; i++) {
                tokens = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());
                distance[a][b] = 1;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(distance));
            int result = 0;
            for (int i = 1; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] != INF || distance[j][i] != INF) {
                        count++;
                    }
                }
                if (count == n) result++;
            }
            output.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(output);
    }
}
