package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15783 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        m = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
    }
    // 백트래킹으로


    private static int count() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) sum++;
            }
        }
        return sum;
    }
}
