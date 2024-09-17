package swea;

import java.io.*;
import java.util.*;

public class SWEA2048 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static String d;
    private static int map[][], result[][];

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            d = tokens.nextToken();

            map = new int[n][n];
            result = new int[n][n];

            for (int i = 0; i < n; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }

            switch (d) {
                case "up":
                    for (int r = 0; r < n; r++) {
                        for (int c = 0; c < n - 1; c++) {
                            if (map[c][r] == 0) continue;

                            int k = c + 1;
                            while (k < n && map[k][r] == 0) k++; // 빈 칸을 건너뛰고
                            if (k < n && map[c][r] == map[k][r]) {
                                map[c][r] *= 2;
                                map[k][r] = 0;
                            }
                        }
                        int idx = 0;
                        for (int c = 0; c < n; c++) {
                            if (map[c][r] != 0) {
                                result[idx++][r] = map[c][r];
                            }
                        }
                    }
                    break;

                case "down":
                    for (int r = 0; r < n; r++) {
                        for (int c = n - 1; c > 0; c--) {
                            if (map[c][r] == 0) continue;

                            int k = c - 1;
                            while (k >= 0 && map[k][r] == 0) k--; // 빈 칸을 건너뛰고
                            if (k >= 0 && map[c][r] == map[k][r]) {
                                map[c][r] *= 2;
                                map[k][r] = 0;
                            }
                        }
                        int idx = n - 1;
                        for (int c = n - 1; c >= 0; c--) {
                            if (map[c][r] != 0) {
                                result[idx--][r] = map[c][r];
                            }
                        }
                    }
                    break;

                case "left":
                    for (int r = 0; r < n; r++) {
                        for (int c = 0; c < n - 1; c++) {
                            if (map[r][c] == 0) continue;

                            int k = c + 1;
                            while (k < n && map[r][k] == 0) k++; // 빈 칸을 건너뛰고
                            if (k < n && map[r][c] == map[r][k]) {
                                map[r][c] *= 2;
                                map[r][k] = 0;
                            }
                        }
                        int idx = 0;
                        for (int c = 0; c < n; c++) {
                            if (map[r][c] != 0) {
                                result[r][idx++] = map[r][c];
                            }
                        }
                    }
                    break;

                case "right":
                    for (int r = 0; r < n; r++) {
                        for (int c = n - 1; c > 0; c--) {
                            if (map[r][c] == 0) continue;

                            int k = c - 1;
                            while (k >= 0 && map[r][k] == 0) k--; // 빈 칸을 건너뛰고
                            if (k >= 0 && map[r][c] == map[r][k]) {
                                map[r][c] *= 2;
                                map[r][k] = 0;
                            }
                        }
                        int idx = n - 1;
                        for (int c = n - 1; c >= 0; c--) {
                            if (map[r][c] != 0) {
                                result[r][idx--] = map[r][c];
                            }
                        }
                    }
                    break;
            }

            // 결과 출력
            output.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    output.append(result[i][j]).append(" ");
                }
                output.append("\n");
            }
        }
        System.out.print(output);
    }
}
