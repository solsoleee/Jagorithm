package chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18428 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    static int deltas[][] = {{0, -1},{0,1}, {1, 0}, {-1, 0}};
    static String map[][];
    static int n;
    static int yes;
    static int no;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new String[n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = tokens.nextToken();
            }

        }

        dfs(0);
        if(yes==0){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }

    //장애물 3개 설치하는 함수
    private static void dfs(int count){
        //장애물 3개가 된다면
        if(count == 3){
            boolean flag = check(map); //학생 여부를 판단
            if(flag) yes++; //학생이 없다면 yes
            return;
        }
        else{
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j].equals("X")){
                        map[i][j] = "O";
                        dfs(count+1);
                        map[i][j]="X";
                    }
                }
            }
        }
    }



    //행열에 선생님이 있는지 확인하는 함수
    private static boolean check(String[][] temp){
        Queue<int[]> que = new LinkedList<>();
        //선생님의 위치를 다 넣어둠
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(temp[i][j].equals("T")){
                    que.offer(new int[]{i,j});
                }
            }
        }
        //que가 비어있지 않을 때까지
        while(!que.isEmpty()){
            int t[] = que.poll();
            for(int d=0; d<4; d++){
                int x = t[0];
                int y = t[1];
                for(int i=0; i<n; i++){
                    x+= deltas[d][0];
                    y+= deltas[d][1];

                    int nx = x;
                    int ny = y;

                    if(nx >=0 && nx<n && ny >=0 && ny<n){
                        if(temp[nx][ny].equals("S")){
                            return false;
                        }
                        //해당 줄에 장애물 있으면 그 해당 줄 취소
                        if(temp[nx][ny].equals("O")){
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }
}

