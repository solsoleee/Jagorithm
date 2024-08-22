package swea;
import java.io.*;
import java.util.*;

public class SWEA요리사 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static int minDifference;
    private static int[][] synergy;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(input.readLine());
            synergy = new int[n][n];
            visited = new boolean[n];
            minDifference = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                for (int j = 0; j < n; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 조합을 통해 A음식에 들어갈 재료 선택
            combination(0, 0);

            output.append("#").append(t).append(" ").append(minDifference).append("\n");
        }
        System.out.print(output);
    }

    // 조합을 통해 식재료를 선택하는 함수
    private static void combination(int start, int count) {
        if (count == n / 2) {
            calculateDifference();
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }

    // 선택된 식재료로 맛의 차이를 계산하는 함수
    private static void calculateDifference() {
        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    totalA += synergy[i][j] + synergy[j][i];
                } else if (!visited[i] && !visited[j]) {
                    totalB += synergy[i][j] + synergy[j][i];
                }
            }
        }

        int difference = Math.abs(totalA - totalB);
        minDifference = Math.min(minDifference, difference);
    }
}
