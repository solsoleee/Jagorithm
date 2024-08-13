package s;

import java.util.*;
import java.io.*;

public class Boj16234 {

    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n, l, r;
    private static int map[][];
    private static int deltas[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static List<int[]> list;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        l = Integer.parseInt(tokens.nextToken());
        r = Integer.parseInt(tokens.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int count = 0;

        while(bfs()){ //이어진 도시가 있을 때까지
            //System.out.println(Arrays.deepToString(map));
            int list_size = list.size();
            int sum=0;
            for(int i=0;i<list_size;i++){
                int temp[] = list.get(i);
                sum+=map[temp[0]][temp[1]];
            }
            int avg = sum/list_size;
            System.out.println(sum + " " +list_size);
            //인구이동
            for(int i=0;i<list_size;i++){
                int temp[] = list.get(i);
                map[temp[0]][temp[1]]=avg;
            }
            System.out.println(Arrays.deepToString(map));
            count++;

        }
        System.out.println(count);

    }

    //bfs(1,0);
    // 1. 양 옆 크기가 차이가 맞는지 확인하는 함수
    // 2. 계산해서 평균으로 퍼지는 함수 (bfs)

    //상하좌우만 확인해서 없는것만 큐에 넣음
    static boolean bfs() {
        list = new ArrayList<>();
        //System.out.println(x +" " + y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d[] : deltas) {
                    boolean flag = true;
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        //System.out.println(Math.abs(map[x][y] - map[nx][ny]));
                        if (Math.abs(map[i][j] - map[nx][ny]) >= l && Math.abs(map[i][j] - map[nx][ny]) <= r) {
                            //System.out.println(nx + "왜안돼" + ny);
                            for (int t = 0; t < list.size(); t++) {
                                int temp[] = list.get(t);
                                if (temp[0] == nx && temp[1] == ny) {
                                    //System.out.println(nx + " " + ny);
                                    flag = false;
                                    break;
                                }
                            }

                            if (flag) {
                                //System.out.println(i + " =냐냐냥" + j);
                                //System.out.println(nx + "이거나옴안돼" + ny);
                                list.add(new int[]{nx, ny});
                                //System.out.println(Math.abs(map[x][y] - map[nx][ny]));

                            }
                        }
                    }
                }
            }
        }
            if (list.isEmpty()) {
                return false; //이어진 도시가 없음
            } else {
                return true; // 이어진 도시가 있음
        }
    }
}