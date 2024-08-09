package chapter13;
import java.util.*;
import java.io.*;

public class Boj18405 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    static int deltas[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());
        int map[][] = new int[n][n];
        Queue<int[]> que = new LinkedList<>();

        // Reading the map and initializing the queue with the virus positions
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
                if (map[i][j] != 0) {
                    que.offer(new int[]{map[i][j], i, j, 0});
                }
            }
        }

        tokens = new StringTokenizer(input.readLine());
        int s = Integer.parseInt(tokens.nextToken());
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());

        List <int[]> list = new ArrayList<>(que);
        list.sort(Comparator.comparingInt(a->a[0]));
        que = new LinkedList<>(list);


        // Sorting the initial queue by virus type
//        List<int[]> list = new ArrayList<>(que);
//        list.sort(Comparator.comparingInt(a -> a[0]));
//        que = new LinkedList<>(list);

        // BFS to simulate virus spreading
        while (!que.isEmpty()) {
            int t[] = que.poll();
            int v = t[0];
            int dx = t[1];
            int dy = t[2];
            int count = t[3];

            if(count >= s) {
                break;
            }

            for (int[] d : deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = v;
                        que.offer(new int[]{v, nx, ny, count + 1});
                    }
                }
            }
        }

        System.out.println(map[x-1][y-1]);
    }
}
