package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 @author 한소리
 @since 2024. 8. 13.
 @link https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
 @timecomplex O(n!)
 @performance 21,508 kb 564 ms
 @category #permutation
 @note */
public class 햄스터 {

    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int res[];
    private static int arr[];
    private static boolean visited[];
    private static int n, x, m, sum;
    private static int [] l, r, s;
    private static int maxSum;
    private static int[] bestRes;
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());

        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken()); // 우리의 개수
            x = Integer.parseInt(tokens.nextToken()); // 각 우리 최대 마리
            m = Integer.parseInt(tokens.nextToken()); // 기록

            arr = new int[x + 1];
            visited = new boolean[x + 1];

            for (int i = 0; i <= x; i++) {
                arr[i] = i;
            }

            res = new int[n]; // 조건에 맞는 후보들
            bestRes = new int[n]; // 최종 정답

            l = new int[m];
            r = new int[m];
            s = new int[m];

            for (int i = 0; i < m; i++) {
                tokens = new StringTokenizer(input.readLine());
                l[i] = Integer.parseInt(tokens.nextToken());
                r[i] = Integer.parseInt(tokens.nextToken());
                s[i] = Integer.parseInt(tokens.nextToken());
            }

            maxSum = -1; // 초기값 설정
            permutation(0);

            if (maxSum == -1) {
                output.append("#").append(t).append(" -1\n");
            } else {
                output.append("#").append(t);
                for (int i = 0; i < n; i++) {
                    output.append(" ").append(bestRes[i]);
                }
                output.append("\n");
            }
        }
        System.out.println(output);
    }

    // 모든 후보들 만들어주는 함수
    private static void permutation(int cnt) {
        if (cnt == n) {
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                int total = 0;
                for (int j = l[i] - 1; j < r[i]; j++) {
                    total += res[j];
                }
                if (total != s[i]) { // m 후보들 중에 하나라도 만족하지 않으면
                    flag = false;
                    break;
                }
            }
            if (flag) { // 후보들 중에서 큰거, 그 중에서도 사전순으로
                int sum = 0;
                for (int i = 0; i < res.length; i++) {
                    sum += res[i];
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    copyArray(res, bestRes);
                } else if (sum == maxSum) { // 후보들 중에 합이 같다면 사전순 정렬
                    if (compareArray(res, bestRes) < 0) {
                        copyArray(res, bestRes);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            res[cnt] = arr[i];
            permutation(cnt + 1);
        }
    }

    // 두 배열을 비교하는 함수
    private static int compareArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) return -1;
            if (a[i] > b[i]) return 1;
        }
        return 0;
    }

    // 최종 정답 저장하는 함수
    private static void copyArray(int[] r, int[] best) {
        for (int i = 0; i < r.length; i++) {
            best[i] = r[i];
        }
    }
}
