package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA창용마을무리의개수 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    static int parents[];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            m = Integer.parseInt(tokens.nextToken());

            // 부모 노드를 가리키는 배열 생성 및 초기화
            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            // 각 간선 정보를 통해 union 연산 수행
            for (int i = 0; i < m; i++) {
                tokens = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());
                union(a, b);
            }

            // 최종 무리의 개수 계산
            Set<Integer> result = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                result.add(findSet(i)); // 모든 노드에 대해 최종 부모 노드를 찾음
            }

            // 결과 출력
            output.append("#").append(t).append(" ").append(result.size()).append("\n");
        }
        System.out.print(output);
    }

    // findSet 메서드에 경로 압축 적용
    private static int findSet(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findSet(parents[x]); // 경로 압축
    }

    // union 메서드에서 부모 설정 시 루트 부모를 기반으로 설정
    private static boolean union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);

        if (rootA == rootB) return false; // 이미 같은 집합에 속해 있음

        // 부모 설정 (작은 숫자를 부모로)
        if (rootA < rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
        return true;
    }
}
