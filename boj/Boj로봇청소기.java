package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj로봇청소기 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m,direction, res;
    private static int [][] map;
    private static int [] robot;
    private static boolean visited[][];
    private static int deltas[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};//북동남서
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        //0은 청소되지 않은 것 1은 벽이 있는 것
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        robot = new int[2];
        tokens = new StringTokenizer(input.readLine());
        robot[0] = Integer.parseInt(tokens.nextToken());
        robot[1] = Integer.parseInt(tokens.nextToken());
        direction = Integer.parseInt(tokens.nextToken());

        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int x = robot[0];
        int y = robot[1];

        while (true) {
            if (map[x][y] == 0) { //현재칸 청소 할 수 있는 경우
                map[x][y] = -1;
                res++;
            }

            //현재 칸의 주변 4칸 중 청소할 수 있는 빈칸이 하나라도 있는 경우
            boolean flag = false;
            for(int i=0; i<4; i++){
                int nx = x + deltas[i][0];
                int ny = y + deltas[i][1];
                if(nx >=0 && nx<n && ny>=0 && ny<m ){
                    if(map[nx][ny]==0){
                        flag = true;
                        break;
                    }
                }
            }
            //현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
            if(!flag)
             {
                 int nx = x - deltas[direction][0];
                 int ny = y - deltas[direction][1];

                //현재에서 후진할 수 있으면 후진
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    //벽이 아니면 후진
                    if (map[nx][ny] != 1) {
                        x = nx;
                        y = ny;
                    } else { //벽이면
                        break; //작동 멈추기
                    }
                }
            }
            //현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
            else if(flag){
                turn(direction); //90도 회전
                int nx = x + deltas[direction][0];
                int ny = y + deltas[direction][1];
                if(nx >=0 && ny<n && ny>=0 && ny<m){
                    if(map[nx][ny]==0){ // 빈칸이 있는 경우 한칸 전진
                        x = nx;
                        y = ny;
                    }
                }
            }

        }
        System.out.println(res);

    }
    private static void turn(int d){
        direction = (direction+1)%4;
    }
}
