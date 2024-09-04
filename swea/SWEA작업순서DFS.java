package swea;

import java.io.*;
import java.util.*;

public class SWEA작업순서DFS {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int v, e;
    private static List<List<Integer>> list;
    private static List<Integer> result;
    private static boolean[] visited;
    private static boolean[] onPath; // 사이클 감지를 위한 배열

    //dfs의 위상 정렬은 사이클을 감지해야 한다.

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            // 그래프 초기화
            tokens = new StringTokenizer(input.readLine());
            v = Integer.parseInt(tokens.nextToken());
            e = Integer.parseInt(tokens.nextToken());
            list = new ArrayList<>(v + 1);
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }
            result = new ArrayList<>(v);
            visited = new boolean[v + 1];
            onPath = new boolean[v + 1];

            // 간선 정보 입력
            tokens = new StringTokenizer(input.readLine());
            for (int i = 0; i < e; i++) {
                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());
                list.get(a).add(b);
            }

            // 위상 정렬 수행 (DFS)
            boolean hasCycle = false;
            for (int i = 1; i <= v; i++) {
                if (!visited[i]) {
                    if (dfs(i)) {
                        hasCycle = true;
                        break;
                    }
                }
            }

            if (hasCycle) {
                output.append("#").append(t).append(" Cycle detected!\n");
            } else {
                output.append("#").append(t).append(" ");
                for (int i = result.size() - 1; i >= 0; i--) {
                    output.append(result.get(i)).append(" ");
                }
                output.append('\n');
            }
        }
        System.out.println(output);
    }

    // DFS 기반 위상 정렬
    private static boolean dfs(int node) {
        visited[node] = true;
        onPath[node] = true; // 현재 노드가 탐색 경로에 있음을 표시
        for (int adj : list.get(node)) {
            if (onPath[adj]) {
                return true; // 사이클이 감지됨
            }
            if (!visited[adj]) {
                if (dfs(adj)) {
                    return true; // 사이클이 감지됨
                }
            }
        }
        onPath[node] = false; // 탐색 경로에서 제거
        result.add(node); // 모든 자식 노드를 방문한 후 현재 노드를 결과에 추가
        return false;
    }
}
