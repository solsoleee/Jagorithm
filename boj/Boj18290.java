package boj;

import java.io.*;
import java.util.*;

public class Boj18290 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m,k;
    private static int map[][]; //후보 배열
    private static boolean visited[][];
    private static int max_value = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        //System.out.println(list);
        combi(0,0,0);
        System.out.println(max_value);
    }
    private static void combi(int start, int cnt, int currentSum){

        if(cnt >= k){
            max_value = Math.max(max_value, currentSum);
            return;
        }
        //2차원 배열을 1차원처럼
        for(int i = start; i<n*m; i++){
            int row = i/m; //현재 인덱스를 행으로 자르기
            int col = i%m;
            if(visited[row][col]) continue;
            //지금 인덱스에서 인접한 행이 아닌것
            if( col+1 < m && visited[row][col+1]
                    || row+1 <n && visited[row+1][col]
                    || col-1 >=0 && visited[row][col-1]
                    || row-1 >=0 && visited[row-1][col]) {
                continue;
            }
            visited[row][col] = true;
            combi(i+1, cnt+1, currentSum+map[row][col]);
            visited[row][col] = false;
        }
    }
}
