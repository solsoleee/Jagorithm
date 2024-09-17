package s;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
    static int map[][] ={{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
    static boolean visited[][] = new boolean[5][5];
    static int[][] deltas = {{0,1}, {1,0}}; //가로일때 세로일 때
    public static void main(String[] args) throws IOException {
        int cnt =0;


    }

    static void bfs(){
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int [] {0,0,0,1,0}); //로봇 초기위치
        visited[0][0] = true;
        visited[0][1] = true;
        int d =0; // 가로는 0 세로는 1이라고 방향 두기
        while(!que.isEmpty()){
            int t[] = que.poll();
            int x1 = t[0];
            int y1 = t[1];
            int x2 = t[2];
            int y2 = t[3];
            int count = t[4];


            if(d==0) {//가로이면 x+1할 때 다 0이 있어야함, 세로이면 y+1을 할때 다  0
                int nx = x2+deltas[0][0];
                int ny = y2+deltas[0][1];
                if(nx >=0 && ny>=0 && nx<map.length && ny<map[0].length){
                    if(map[nx][ny]==0){
                        que.offer(new int [] {x2,y2,nx,ny, count+1});
                        visited[nx][ny] = true;
                    }
                }
            }

        }


    }
}



