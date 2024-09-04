package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj주사위굴리기 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m,x,y,k;
    private static int map[][], dice[][];
    private static int kArr[];
    public static void main(String[] args) throws IOException {
        dice = new int[4][3];
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        x = Integer.parseInt(tokens.nextToken());
        y = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        kArr = new int[k];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<k; i++){
            kArr[i] = Integer.parseInt(tokens.nextToken());
        }
        for(int c : kArr){
            rotate(c);
            System.out.println(dice[1][1]); //윗면 출력
        }
    }

    private static void rotate(int command){
        switch(command){
            case 1:
                if(y+1 <m){
                    //dice를 왼쪽으로 로테이션
                    y = y+1;
                    //map[x][y] == 0 이라면 map[x][y] = dice[1][1]
                    //0이 아니라면 dice[1][1] = map[x][y]
                }
                break;
            case 2:
                //서쪽으로
                if(y-1>=0){
                    //dice를 왼쪽으로 로테이션
                    y = y-1;
                    //map[x][y] == 0 이라면 map[x][y] = dice[1][1]
                    //0이 아니라면 dice[1][1] = map[x][y]
                }
                break;
            case 3:
                if(x-1 >=0){
                    x = x-1;
                    //1번 인덱스 위로 밀기
                    //map[x][y] == 0 이라면 map[x][y] = dice[1][1]
                    //0이 아니라면 dice[1][1] = map[x][y]
                }

                break;
            case 4:
                //x,y에서 아래로 가능하다면 이동
                int idx = x+1;
                if(idx < n){
                    x = idx; //주사위 이동
                    for(int i=0; i<4; i++){

                    }
                    //1번 인덱스를 아래로 밀기 [i][1] 이거 말하는거
                    //주사위 인덱스 dice[1][1] 만 보면 됨
                    //map[idx][y] == 0 이라면 map[idx][y] = dice[1][1]
                    //0이 아니라면 dice[1][1] = map[idx][y]
                }
                break;
        }
    }

}
