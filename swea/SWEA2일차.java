package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA2일차 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int map[][] = new int[100][100];

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            int test = Integer.parseInt(input.readLine());
            for (int i = 0; i < 100; i++) {
                tokens = new StringTokenizer(input.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
            // 도착점 찾기
            int x = 99;
            int y = 0;
            for (int i = 0; i < 100; i++) {
                if (map[99][i] == 2) {
                    y = i;
                    break;
                }
            }
            // 출발점 찾기
            while (x > 0) {
                if (y > 0 && map[x][y - 1] == 1) {  // 왼쪽으로 이동
                    while (y > 0 && map[x][y - 1] == 1) {
                        y--;
                    }
                } else if (y < 99 && map[x][y + 1] == 1) {  // 오른쪽으로 이동
                    while (y < 99 && map[x][y + 1] == 1) {
                        y++;
                    }
                }
                x--;  // 위로 이동
            }
            output.append("#").append(test).append(" ").append(y).append("\n");
        }
        System.out.print(output);
    }
}
